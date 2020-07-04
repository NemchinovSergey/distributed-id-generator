package com.nsergey.generator.controller;

import com.nsergey.generator.error.ErrorResponse;
import com.nsergey.generator.error.IdGenerationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(IdGenerationException.class)
    public ResponseEntity<ErrorResponse> handleApiException(IdGenerationException ex) {
        ErrorResponse response = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}