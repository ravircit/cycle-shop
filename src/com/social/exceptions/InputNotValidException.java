package com.social.exceptions;

public class InputNotValidException extends RuntimeException {
    public InputNotValidException() {
    }

    public InputNotValidException(String message) {
        super(message);
    }
}
