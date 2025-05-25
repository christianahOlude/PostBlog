package org.example.exceptions;

public class EmailCantBeEmptyException extends RuntimeException {
    public EmailCantBeEmptyException(String message) {
        super(message);
    }
}
