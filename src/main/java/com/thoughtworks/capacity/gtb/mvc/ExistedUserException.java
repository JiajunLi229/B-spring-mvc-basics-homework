package com.thoughtworks.capacity.gtb.mvc;

public class ExistedUserException extends RuntimeException {
    public ExistedUserException(String message) {
        super(message);
    }
}
