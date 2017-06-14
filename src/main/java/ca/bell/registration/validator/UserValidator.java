package ca.bell.registration.validator;

import ca.bell.registration.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (o == null) {
            return;
        }

        final User user = (User) o;

        validateUsername(user, errors);
    }

    private void validateUsername(final User user, final Errors errors) {

        if (isBlank(user.getUsername()) || user.getUsername().length() < 5 || user.getUsername().length() > 255) {

            errors.rejectValue("username", null, "Le username est obligatoire (min 5 max 255)");
        }
    }

    private void validateFirstName(final User user, final Errors errors) {
        // TODO: complet...
    }

    // TODO: autre valication
}
