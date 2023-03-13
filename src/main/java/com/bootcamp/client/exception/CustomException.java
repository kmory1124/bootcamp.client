package com.bootcamp.client.exception;

public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -8299533233042901359L;

    public CustomException(String message){
        super(message);
    }
}
