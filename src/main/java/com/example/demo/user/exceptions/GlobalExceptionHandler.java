package com.example.demo.user.exceptions;

import com.example.demo.user.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundByIdEx.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse userNotFoundExceptionHandler(UserNotFoundByIdEx ex){
        return new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(EmailAlreadyInUseEx.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse emailAlreadyInUseExceptionHandler(EmailAlreadyInUseEx ex){
        return new ApiResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
    }
}
