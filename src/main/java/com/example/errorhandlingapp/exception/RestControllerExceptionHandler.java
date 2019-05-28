package com.example.errorhandlingapp.exception;

import com.rccl.middleware.common.exceptions.MiddlewareError;
import javassist.NotFoundException;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    private final String ERROR_CODE = "007" ;


    @ExceptionHandler(value = {DatabaseException.class, NotFoundException.class})
    public ResponseEntity<MiddlewareTransportExceptionWrapper> handleRestCallFailures(RuntimeException ex) {

        List<MiddlewareError> errors = Collections.singletonList(MiddlewareError.builder()
                .id(UUID.randomUUID())
                .internalMessage(ex.getMessage())
                .time(Instant.now().toEpochMilli())
                .errorCode(ERROR_CODE)
                .build());

        val middlewareTransportExceptionWrapper = new MiddlewareTransportExceptionWrapper(
                HttpStatus.NOT_FOUND.value(),
                errors);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(middlewareTransportExceptionWrapper);
    }

    @ExceptionHandler(value = {CustomException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<MiddlewareTransportExceptionWrapper> handleUnexpectedFailures(RuntimeException ex) {

        List<MiddlewareError> errors = Collections.singletonList(MiddlewareError.builder()
                .id(UUID.randomUUID())
                .internalMessage(ex.getMessage())
                .time(Instant.now().toEpochMilli())
                .errorCode(ERROR_CODE)
                .build());

        val middlewareTransportExceptionWrapper = new MiddlewareTransportExceptionWrapper(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                errors);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(middlewareTransportExceptionWrapper);
    }

}
