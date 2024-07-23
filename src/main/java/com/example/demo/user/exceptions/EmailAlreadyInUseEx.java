package com.example.demo.user.exceptions;

public class EmailAlreadyInUseEx extends RuntimeException{
    public EmailAlreadyInUseEx(String email) {
        super("Email: " + email + " jest zajęty");
    }
}
