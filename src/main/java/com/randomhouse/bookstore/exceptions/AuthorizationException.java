package com.randomhouse.bookstore.exceptions;

import lombok.Getter;

@Getter
public class AuthorizationException extends RuntimeException{

    private final String message;
    private final String code;

    public AuthorizationException(String message, String code){
        super(message);
        this.code = code;
        this.message = message;
    }
}
