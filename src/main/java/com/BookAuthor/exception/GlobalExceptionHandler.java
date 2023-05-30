package com.BookAuthor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(RecordNotFoundException recordNotFoundException){
        ResponseEntity<String> recordNotFound = new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
        return recordNotFound;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globalException(Exception exception){
        ResponseEntity<String> internalServerError = new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        return internalServerError;
    }
}
