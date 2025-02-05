package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandLineInterface {
    public static void main(String[] args) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input your name");
        String clientName = scanner.nextLine();
        Product computer1 = new Computer(1, "Dell", BigDecimal.valueOf(123), 100);
        Product computer2 = new Computer(1, "Dell", BigDecimal.valueOf(123), 100);
        Product computer3 = new Computer(1, "Dell", BigDecimal.valueOf(123), 100);
        Product electronics = new Electronics(20, "cable", BigDecimal.valueOf(10), 1);
        Electronics[] accessories1 = {(Electronics) electronics};
        Product smartphone1 = new Smartphone(1, "samsung", BigDecimal.valueOf(1000.1), 10, "red", 1200);
        Product smartphone2 = new Smartphone(1, "samsung", BigDecimal.valueOf(1000.1), 10, "red", 1200, accessories1);
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3, electronics, smartphone1));
        ProductManager allProducts = new ProductManager(products);
        Cart cart = new Cart(clientName);
        do {
            System.out.println("Choose option");
            System.out.println("1 - View Products");
            System.out.println("2 - Add to Cart");
            System.out.println("3 - Order");
            System.out.println("0 - Quit");

            switch (scanner.nextInt()){
                case 1:
                    allProducts.showProducts();
                    break;
                case 2:
                    cart.addProduct(computer1);
                    break;
                case 3:
                    OrderProcessor.process(new Order(cart));
                    break;
                case 0:
                    System.out.println("bye");
                    running = false;
                    break;
                default:
                    break;

            }
                
            
        }while (running);
    }
}
