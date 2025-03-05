package com.company;

import java.util.Scanner;
import java.util.UUID;

public class CommandLineImpl implements CommandLine {
    Scanner scanner = new Scanner(System.in);

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
    public Order createOrder(Cart cart) {
        System.out.println("Creating order form cart:\n " + cart);
        return new Order(cart);
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Processing Order");
        OrderProcessor op = new OrderProcessor(order);
        op.process();
    }

    @Override
    public void addToCart(ProductManager pm, Cart cart) {
        System.out.println("Give product ID you want to add to cart");
        String id = scanner.nextLine();
        System.out.println("Give product quantity you want to add to cart");
        String quant = scanner.nextLine();
        int quantity = 0;
        try {
            quantity = Integer.parseInt(quant);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        pm.addProductToCart(cart, UUID.fromString(id), quantity);
        System.out.println("added product with id: " + quant + " to cart");
    }

    @Override
    public void removeFromCart(ProductManager pm, Cart cart) {
        System.out.println("Give product ID you want to remove from cart");
        String id = scanner.nextLine();
        System.out.println("Give product quantity you want to remove from cart");
        String quant = scanner.nextLine();
        int quantity = 0;
        try {
            quantity = Integer.parseInt(quant);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        pm.removeProductFromCart(cart, UUID.fromString(id), quantity);
        System.out.println("removed product with id: " + id + " from cart");
    }
}
