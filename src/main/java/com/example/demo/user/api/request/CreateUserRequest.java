package com.example.demo.user.api.request;

public record CreateUserRequest(
        String firstname,
        String lastname,
        String email,
        String password
) {
}
