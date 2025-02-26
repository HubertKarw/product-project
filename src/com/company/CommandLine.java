package com.company;

public interface CommandLine {
    void printCart(Cart cart);

    void printProducts(ProductManager productManager);

    void printOrder(Order order);

    void addToCart(ProductManager pm, Cart cart, Product product);

    void removeFromCart(ProductManager pm, Cart cart, Product product);
}
