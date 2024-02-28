package com.maria.library.exceptions;

public class BookAlreadyExistingException extends RuntimeException{
    public BookAlreadyExistingException(String message) {
        super(message);
    }
}
