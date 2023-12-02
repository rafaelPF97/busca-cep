package com.test.example.search.domain.exception;

public class ZipCodeNotFoundException extends RuntimeException {

    public ZipCodeNotFoundException(String message) {
        super(message, null, false, false);
    }
}
