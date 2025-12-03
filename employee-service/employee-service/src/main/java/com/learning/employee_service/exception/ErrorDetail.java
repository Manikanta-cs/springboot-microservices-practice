package com.learning.employee_service.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;

public class ErrorDetail {
    private LocalDateTime timeStamp;
    private String message;
    private String uriPath;

    public ErrorDetail() {
    }

    public ErrorDetail(LocalDateTime timeStamp, String message, String uriPath) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.uriPath = uriPath;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getUriPath() {
        return uriPath;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }
}
