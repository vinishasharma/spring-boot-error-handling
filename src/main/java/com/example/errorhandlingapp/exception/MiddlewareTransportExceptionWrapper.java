package com.example.errorhandlingapp.exception;

import com.rccl.middleware.common.exceptions.MiddlewareError;
import lombok.Getter;

import java.util.List;

@Getter
class MiddlewareTransportExceptionWrapper {

    Integer status;
    List<MiddlewareError> errors;

    public MiddlewareTransportExceptionWrapper(Integer status, List<MiddlewareError> errors) {
        this.status = status;
        this.errors = errors;
    }
}