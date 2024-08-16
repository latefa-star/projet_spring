package com.example.test.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApiExceptionBase{

    public ConflictException(String msg) {
        super(msg);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
