package com.company;

public class ProductNotInShopException extends RuntimeException {
    public ProductNotInShopException(String errorMessage) {

    }

    public ProductNotInShopException() {
        super("No such product in shop");
    }
}
