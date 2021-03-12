package com.mph.book;

public class InvalidTraderException extends Throwable {
    private long serialVersionUID=1L;

    public InvalidTraderException(String message){
            super(message);
    }
}
