package com.company;

public class CommandLineImpl implements CommandLine {
    public CommandLineImpl() {
    }

    @Override
    public void printCart(Cart cart) {
        System.out.println("Cart:");
        System.out.println(cart);
    }

    @Override
    public void printProducts(ProductManager productManager) {
        System.out.println("Products is stock:");
        productManager.showProducts();
    }

    @Override
    public void printOrder(Order order) {
        System.out.println("Order:");
        System.out.println(order);
    }

    @Override
    public Order createOrder(Cart cart){
        System.out.println("Creating order form cart:\n "+ cart);
        return new Order(cart);
    }
    @Override
    public void processOrder(Order order){
        System.out.println("Processing Order");
        OrderProcessor.process(order);
    }
    @Override
    public void addToCart(ProductManager pm, Cart cart, Product product, int quantity) {
        pm.addProductToCart(cart, product.getId(), quantity);
        System.out.println("added product with id: "+product.getId()+" to cart");
    }

    @Override
    public void removeFromCart(ProductManager pm, Cart cart, Product product, int quantity) {
        pm.removeProductFromCart(cart, product.getId(), quantity);
        System.out.println("removed product with id: "+product.getId()+" from cart");
    }
}
