package com.example.test.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ErrorDetail {
    private String message;
    private String url;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date timestamp;

    public ErrorDetail() {
        timestamp = new Date();
    }

    public ErrorDetail(String message, String url) {
        this();
        this.message = message;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
