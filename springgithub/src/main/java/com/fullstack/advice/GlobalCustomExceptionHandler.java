package com.fullstack.advice;


import com.fullstack.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalCustomExceptionHandler {
    public ResponseEntity<Object> handleCustomException(RecordNotFoundException exception ){
        return  new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

    }
}
