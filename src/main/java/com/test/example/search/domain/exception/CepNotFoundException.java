package com.test.example.search.domain.exception;

public class CepNotFoundException extends RuntimeException {

    public CepNotFoundException(String message) {
        super(message, null, false, false);
    }
}
