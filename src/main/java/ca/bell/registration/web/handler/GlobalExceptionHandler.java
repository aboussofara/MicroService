package ca.bell.registration.web.handler;

import ca.bell.registration.dto.exception.ErrorMessage;
import ca.bell.registration.exception.ErrorException;
import ca.bell.registration.exception.NotFoundException;
import ca.bell.registration.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {NotFoundException.class})
    public ErrorMessage notFoundExceptionHandler(HttpServletRequest req, Principal user, NotFoundException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {ValidationException.class})
    public ErrorMessage validatorExceptionHandler(HttpServletRequest req, Principal user, ValidationException ex) {
        return new ErrorMessage(ex.getMessage(), ex.getErrorMessages());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {ErrorException.class})
    public ErrorMessage errorExceptionHandler(HttpServletRequest req, Principal user, ErrorException ex) {
        return new ErrorMessage(ex.getMessage());
    }

}
