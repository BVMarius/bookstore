package com.randomhouse.bookstore.exceptions;

import lombok.Getter;

@Getter
public class UnprocessableEntityException extends RuntimeException{

    private final String message;
    private final String code;
    private final String detail;

    public UnprocessableEntityException(String message, String code, String detail){
        super(message);
        this.message = message;
        this.code = code;
        this.detail = detail;
    }

}
