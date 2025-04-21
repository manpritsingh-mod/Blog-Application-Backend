package com.example.blogapplication.util;

import com.example.blogapplication.exception.BlogNotFoundException;
import com.example.blogapplication.exception.InvalidCredentialsException;
import com.example.blogapplication.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

        @ExceptionHandler
        public ResponseEntity<ErrorStructure> handleUserNotFoundException(UserNotFoundException ex){
            ErrorStructure errorStructure = new ErrorStructure();
            errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
            errorStructure.setErrorMessage(ex.getMessage());

            return new ResponseEntity<ErrorStructure>(errorStructure, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler
        public ResponseEntity<ErrorStructure> handleBlogNotFoundException(BlogNotFoundException ex){
            ErrorStructure errorStructure = new ErrorStructure();
            errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
            errorStructure.setErrorMessage(ex.getMessage());

            return new ResponseEntity<ErrorStructure>(errorStructure, HttpStatus.NOT_FOUND);
        }


        @ExceptionHandler
        public ResponseEntity<ErrorStructure> handleInvalidCredentialsException(InvalidCredentialsException ex) {
            ErrorStructure errorStructure = new ErrorStructure();
            errorStructure.setErrorCode(HttpStatus.UNAUTHORIZED.value()); // 401 Unauthorized
            errorStructure.setErrorMessage(ex.getMessage());

            return new ResponseEntity<>(errorStructure, HttpStatus.UNAUTHORIZED);
        }

}
