package com.company;

public class ProductNotInCartException extends RuntimeException {
    public ProductNotInCartException(String errorMessage) {
        super(errorMessage);
    }

    public ProductNotInCartException() {
        super("Product not in cart");
    }
}
