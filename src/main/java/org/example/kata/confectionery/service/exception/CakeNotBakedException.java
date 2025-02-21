package org.example.kata.confectionery.service.exception;

public class CakeNotBakedException extends RuntimeException {
    public CakeNotBakedException(String message) {
        super(message);
    }
}
