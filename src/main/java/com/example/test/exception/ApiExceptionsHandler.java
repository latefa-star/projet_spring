package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiExceptionBase.class)
    public ResponseEntity<ErrorDetail> HandlException(ApiExceptionBase ex, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetail, ex.getStatus());
    }


}
