package service.tweetservicediscussion.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseTo> handleConstraintViolationException(ConstraintViolationException exception) {
        ErrorResponseTo errorResponseTo = new ErrorResponseTo(exception.getMessage(), HttpStatus.BAD_REQUEST.value() + ExceptionStatus.VALIDATION_ERROR_EXCEPTION_STATUS.getValue());
        return new ResponseEntity<>(errorResponseTo, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseTo> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        ErrorResponseTo errorResponseTo = new ErrorResponseTo(exception.getMessage(), HttpStatus.FORBIDDEN.value() + ExceptionStatus.DB_CONSTRAINTS_EXCEPTION_STATUS.getValue());
        return new ResponseEntity<>(errorResponseTo, HttpStatus.FORBIDDEN);
    }

    @ResponseBody
    @ExceptionHandler(NoSuchMessageException.class)
    public ResponseEntity<ErrorResponseTo> handleNoSuchMessageException(NoSuchMessageException exception) {
        ErrorResponseTo errorResponseTo = new ErrorResponseTo(exception.getMessage(), HttpStatus.NOT_FOUND + ExceptionStatus.NO_SUCH_MESSAGE_EXCEPTION_STATUS.getValue());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseTo);
    }
}
