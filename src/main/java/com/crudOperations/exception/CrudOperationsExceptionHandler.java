package com.crudOperations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CrudOperationsExceptionHandler {
    @ExceptionHandler
    public ResponseEntity handleBookAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException) {
        return new ResponseEntity("User already exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity handleBookNotFoundException(UserNotFoundException userNotFoundException) {
        return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
    }
}
