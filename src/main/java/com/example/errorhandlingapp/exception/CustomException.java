package com.example.errorhandlingapp.exception;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super("Custom exception : "+ message);
    }
}
