package com.example.test.exception;


import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiExceptionBase {

    public NotFoundException(String msg) {
        super(msg);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }


}
