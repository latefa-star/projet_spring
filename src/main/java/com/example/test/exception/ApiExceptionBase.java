package com.example.test.exception;


import org.springframework.http.HttpStatus;

public abstract class ApiExceptionBase extends RuntimeException {

    public ApiExceptionBase(String msg)
    {
     super(msg);
    }

    public abstract HttpStatus getStatus() ;
}
