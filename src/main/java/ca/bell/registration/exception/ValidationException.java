package ca.bell.registration.exception;

import ca.bell.registration.dto.exception.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends GenericException {

    public ValidationException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Errors related to validating your information.");
    }

    public ValidationException(final String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), message);
    }

    public ValidationException(final String message, final Throwable cause) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), message, cause);
    }

    public ValidationException(final BindingResult result) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Errors related to validating your information.");
        generatedValidationErrorsByBindingResult(result);
    }

    public static void throwIfHasError(final BindingResult result) throws ValidationException {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
    }

    private void generatedValidationErrorsByBindingResult(final BindingResult result) {
        if (result.hasErrors()) {

            List<ObjectError> errors = result.getAllErrors();
            FieldError fe;
            List<ValidationError> validationErrors = new ArrayList<>();
            String object, responseObject, attribute, responseAttribute, message;
            String[] findChildObject;

            for (ObjectError oe : errors) {

                fe = (FieldError) oe;

                findChildObject = fe.getField().split("\\.");
                if (findChildObject.length == 2) {

                    responseObject = findChildObject[0];
                    responseAttribute = findChildObject[1];

                } else {
                    responseObject = fe.getObjectName().replace("DTO", "");
                    responseAttribute = fe.getField();
                }

                object = splitCamelCase(responseObject).toLowerCase();
                attribute = splitCamelCase(responseAttribute).toLowerCase();
                message = "The \'" + attribute + "\' in \'" + object + "\' " + fe.getDefaultMessage();
                validationErrors.add(new ValidationError(responseObject, responseAttribute, message));
            }
            super.setValidationErrors(validationErrors);
        }
    }

    private static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format(
                        "%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ), " ");
    }

}