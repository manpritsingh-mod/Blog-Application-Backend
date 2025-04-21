package com.example.blogapplication.service.impl;

public class UserExistException extends RuntimeException {
    public UserExistException(String message) {
        super(message);
    }
}
