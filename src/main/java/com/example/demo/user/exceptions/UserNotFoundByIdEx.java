package com.example.demo.user.exceptions;

public class UserNotFoundByIdEx extends RuntimeException{

    public UserNotFoundByIdEx(Long id) {
        super("Nie można odnaleźć użytkownika z id: " + id);
    }
}
