package ca.bell.registration.exception;


import ca.bell.registration.dto.exception.ValidationError;

import java.util.List;

public abstract class GenericException extends Exception {

    private static final String VALIDATION_ERRORS = "VALIDATION_ERRORS";

    private final int status;

    private String errorMessage;

    private List<ValidationError> validationErrors;

    GenericException(int httpStatus, String errorMessage) {
        super(errorMessage);
        this.status = httpStatus;
        this.errorMessage = errorMessage;
    }

    GenericException(int httpStatus, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.status = httpStatus;
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<ValidationError> getErrorMessages() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.errorMessage = VALIDATION_ERRORS;
        this.validationErrors = validationErrors;
    }

}