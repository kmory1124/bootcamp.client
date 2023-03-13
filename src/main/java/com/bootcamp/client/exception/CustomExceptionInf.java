package com.bootcamp.client.exception;

public class CustomExceptionInf extends RuntimeException {

    private  static final long serialVersionUID = 7307685192056731068L;
    public CustomExceptionInf(String message){
        super(message);
    }
}
