package com.example.errorhandlingapp.exception;

public class DatabaseException  extends RuntimeException {

    public DatabaseException(String message) {
        super("Database exception : "+ message);
    }
}
