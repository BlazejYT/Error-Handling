package com.example.demo.user.api.response;

import com.example.demo.user.api.ApiResponse;

public class CreateUserResp extends ApiResponse {
    public CreateUserResp() {
        super("Utworzono użytkownika poprawnie", 201);
    }
}
