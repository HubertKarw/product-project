package com.company;

public class CommendLineImpl implements CommandLine {
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
    public void addToCart(ProductManager pm, Cart cart, Product product, int quantity) {
        pm.addProductToCart(cart, product.getId(), quantity);
        System.out.println("added product with id: "+product.getId()+" to cart");
    }

    @Override
    public void removeFromCart(ProductManager pm, Cart cart, Product product, int quantity) {
        pm.removeProductFromCart(cart, product.getId(), quantity);
        System.out.println("removed product with id: "+product.getId()+" to cart");
    }
}
