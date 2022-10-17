package com.crudOperations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CrudOperationsExceptionHandler {
    @ExceptionHandler
    public ResponseEntity handleBookNotFoundException(UserNotFoundException userNotFoundException) {
        return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
    }
}
