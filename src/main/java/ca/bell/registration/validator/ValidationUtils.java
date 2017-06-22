package ca.bell.registration.validator;


import ca.bell.registration.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.validation.*;

public abstract class ValidationUtils {

    public static final String EMAIL_REGEX = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,8}$";

    public static void validate(Validator validator, Object target, String objectName) throws ValidationException {
        final BindingResult bindingResult = new BeanPropertyBindingResult(target, objectName);
        validator.validate(target, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
    }

    public static void rejectIfNull(Errors errors, String field, String errorCode, Object[] errorArgs, String defaultMessage) {
        Object value = errors.getFieldValue(field);
        if (value == null) {
            errors.rejectValue(field, errorCode, errorArgs, defaultMessage);
        }
    }

    public static void invokeValidatorByOtherNestedPath(final String nestedPath, final Validator validator, final Object obj, final Errors errors) {
        try {
            errors.pushNestedPath(nestedPath);
            org.springframework.validation.ValidationUtils.invokeValidator(validator, obj, errors);
        } finally {
            errors.popNestedPath();
        }
    }

    public static boolean validEmail(final String email) {
        return StringUtils.isNotBlank(email) && email.matches(EMAIL_REGEX);
    }

    public static void logErrorResult(final Errors errors, final Logger LOGGER) {
        if (LOGGER.isDebugEnabled()) {
            try {
                if (errors.getAllErrors() != null && errors.getAllErrors().size() >= 1) {
                    LOGGER.debug("==================================================================");
                    LOGGER.debug("Validator result,");
                    LOGGER.debug("Number error: " + errors.getAllErrors().size());
                    LOGGER.debug("==================================================================");

                    java.util.List<ObjectError> allErrors = errors.getAllErrors();
                    for (int i = 0; i < allErrors.size(); i++) {
                        ObjectError objectError = allErrors.get(i);

                        LOGGER.debug("==================================================================");
                        LOGGER.debug("Error #" + i + " Object Name     = [" + objectError.getObjectName() + "]");
                        LOGGER.debug("Error #" + i + " Field           = [" + ((FieldError) objectError).getField() + "]");
                        LOGGER.debug("Error #" + i + " Default Message = [" + objectError.getDefaultMessage() + "]");

                        if (i == allErrors.size() - 1) {
                            LOGGER.debug("==================================================================");
                        }
                    }
                }
            } catch (Exception ignore) {
                LOGGER.debug("Exception");
            }
        }
    }

}