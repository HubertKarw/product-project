package com.company;

public class ProductNotInCartException extends Exception{
    public ProductNotInCartException(String errorMessage){
        super(errorMessage);
    }
}
