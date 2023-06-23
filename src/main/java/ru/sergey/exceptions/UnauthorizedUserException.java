package ru.sergey.exceptions;

public class UnauthorizedUserException extends RuntimeException {
    public UnauthorizedUserException(String msg) {
        super(msg);
    }
}
