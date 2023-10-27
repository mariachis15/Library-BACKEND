package com.maria.library.exceptions;

public class BookAuthorNotFoundException extends RuntimeException {
    public BookAuthorNotFoundException(String message) {
        super(message);
    }
}
