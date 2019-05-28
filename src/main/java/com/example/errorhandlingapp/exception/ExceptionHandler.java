package com.example.errorhandlingapp.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionHandler {

    private ExceptionHandler() {

    }

    public static Exception handleException(Throwable ex, String errorMessagePrefix) {

        String errorReason;

        if (ex.getMessage() == null) {

            errorReason = "Unknown error occurred.";

        } else {

            errorReason = ex.getMessage();

        }

        String errorMessage = errorMessagePrefix + errorReason;

        log.error(errorMessage, ex);

        throw new CustomException(ex.toString());
    }
}

