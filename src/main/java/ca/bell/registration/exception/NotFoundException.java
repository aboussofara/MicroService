package ca.bell.registration.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GenericException {

    private static final String defaultMessage = "The Item you are trying to access does not exist";

    public NotFoundException() {
        super(HttpStatus.NOT_FOUND.value(), defaultMessage);
    }

    public NotFoundException(Throwable cause) {
        super(HttpStatus.NOT_FOUND.value(), defaultMessage, cause);
    }

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(HttpStatus.NOT_FOUND.value(), message, cause);
    }

}