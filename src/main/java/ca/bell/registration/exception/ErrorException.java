package ca.bell.registration.exception;

import org.springframework.http.HttpStatus;

public class ErrorException extends GenericException {

    private static final String defaultMessage = "Internal errors.";

    public ErrorException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), defaultMessage);
    }

    public ErrorException(Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), defaultMessage, cause);
    }

    public ErrorException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public ErrorException(String message, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, cause);
    }

}