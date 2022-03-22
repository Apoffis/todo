package com.example.ulbitv.exceptions;

public class UserNotFoundException extends RuntimeException {

    private Long userId;

    private String message;

    public UserNotFoundException(Long userId) {
        this.userId = userId;
        this.message = "User with " + userId + " not found!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
