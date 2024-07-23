package com.example.demo.user.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApiResponse {

    private String message;
    private Integer code;
    private LocalDateTime timestamp;

    public ApiResponse() {
    }

    public ApiResponse(String message, Integer code) {
        this.message = message;
        this.code = code;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
