package com.company;

public interface CommandLine {
    void printCart(Cart cart);

    void printProducts(ProductManager productManager);

    void printOrder(Order order);

    Order createOrder(Cart cart);

    void processOrder(Order order);

    void addToCart(ProductManager pm, Cart cart);

    void removeFromCart(ProductManager pm, Cart cart);
}
