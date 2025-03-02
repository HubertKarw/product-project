package com.company;

public class InvalidDiscountException extends RuntimeException {
    public InvalidDiscountException(String errorMessage) {

    }

    public InvalidDiscountException() {
        super("Provided discount is invalid");
    }
}
