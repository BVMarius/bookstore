package com.randomhouse.bookstore.exceptions;

import lombok.Getter;

@Getter
public class BadRequestBodyException extends RuntimeException {

    private final String message;
    private final String code;

    public BadRequestBodyException(String message, String code){
        super(message);
        this.message = message;
        this.code = code;
    }

}
