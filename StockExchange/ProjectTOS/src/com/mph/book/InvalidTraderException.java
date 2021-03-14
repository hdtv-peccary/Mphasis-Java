package com.mph.book;

public class InvalidTraderException extends Exception {
    private long serialVersionUID = 1L;


    public InvalidTraderException(String message) {
        super(message);
    }
}
