package ru.Exceptions;

public class SessionNotFoundException extends RuntimeException {

    public SessionNotFoundException(String s) {
        super(s);
    }
}
