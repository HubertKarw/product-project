package com.company;

public interface CommandLine {
    void printCart(Cart cart);

    void printProducts(ProductManager productManager);

    void printOrder(Order order);

    void addToCart(Cart cart, Product product);

    void removeFromCart(Cart cart, Product product);
}
