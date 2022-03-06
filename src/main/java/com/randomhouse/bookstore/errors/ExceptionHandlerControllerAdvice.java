package com.randomhouse.bookstore.errors;

import com.randomhouse.bookstore.exceptions.AuthorizationException;
import com.randomhouse.bookstore.exceptions.BadRequestBodyException;
import com.randomhouse.bookstorecontrollers.model.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerControllerAdvice {


    @ExceptionHandler(BadRequestBodyException.class)
    public ResponseEntity<ValidationError> handle(BadRequestBodyException ex){
        ValidationError validationError = new ValidationError();
        validationError.code(ex.getCode());
        validationError.detail(ex.getMessage());
        return new ResponseEntity<>(validationError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<ValidationError> handle(AuthorizationException ex){
        ValidationError validationError = new ValidationError();
        validationError.detail(ex.getMessage());
        validationError.code(ex.getCode());
        return new ResponseEntity<>(validationError, HttpStatus.FORBIDDEN);
    }


}
