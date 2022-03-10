package com.jcopy.jcopy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TaskDoesNotExistException.class)
    public ResponseEntity<ErrorResponse> handleTaskDoesNotExistException(TaskDoesNotExistException ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse();
        err.setErrorMessage(ex.getMessage());
        err.setPath(req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<ErrorResponse> handleUserDoesNotExistException(UserDoesNotExistException ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse();
        err.setErrorMessage(ex.getMessage());
        err.setPath(req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
