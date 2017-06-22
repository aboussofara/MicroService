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

        if (isBlank(user.getUsername()) || user.getUsername().length() < 1 || user.getUsername().length() > 255) {

            errors.rejectValue("username", null, "Le username est obligatoire (min 1 max 255)");
        }
    }

    private void validatePassword(final User user, final Errors errors) {

        if (isBlank(user.getPassword()) || user.getPassword().length() < 1 || user.getPassword().length() > 255) {

            errors.rejectValue("password", null, "Le password est obligatoire (min 1 max 255)");
        }
    }

    private void validateFirstName(final User user, final Errors errors) {

        if (isBlank(user.getFirstName()) || user.getFirstName().length() > 255) {

            errors.rejectValue("firstName", null, "Le first name a un max de 255");
        }
    }

    private void validateLastName(final User user, final Errors errors) {

        if (isBlank(user.getLastName()) || user.getLastName().length() > 255) {

            errors.rejectValue("lastName", null, "Le last name a un max de 255");
        }
    }

}
