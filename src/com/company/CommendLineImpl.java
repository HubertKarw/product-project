package com.company;

public class CommendLineImpl implements CommandLine{
    @Override
    public void printCart(Cart cart) {
        System.out.println(cart);
    }

    @Override
    public void printProducts(ProductManager productManager) {
        productManager.showProducts();
    }

    @Override
    public void printOrder(Order order) {
        System.out.println(order);
    }

    @Override
    public void addToCart(ProductManager pm, Cart cart, Product product) {
    }

    @Override
    public void removeFromCart(ProductManager pm, Cart cart, Product product) {
    }
}
