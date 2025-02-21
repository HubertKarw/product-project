package com.company;

import com.company.test.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Test.creatingAndCheckingCorrectDisplayOfAllProducts();
//        Test.processorTest();
//        Test.ramTest();
//        Test.addingAndRemovingProductsToProductManager();
//        Test.creatingClient();
//        Test.creatingCartAndPrintingInformation();
        Client client = new Client("123", "123");
        Smartphone s = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200);
        Smartphone s1 = new Smartphone("samsungg", BigDecimal.valueOf(1201), 11, "red", 1200);
        Cart cart = new Cart(client);
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(s, s1));
        ProductManager pm = new ProductManager(products);
        pm.addProductToCart(cart, s.getId(), 1);
        System.out.println(cart);
        System.out.println(pm);
        pm.addProductToCart(cart, s.getId(), 1);
        System.out.println(cart);
        System.out.println(pm);
        pm.removeProductFromCart(cart, s.getId(), 1);
        System.out.println(cart);
        System.out.println(pm);
        pm.removeProductFromCart(cart, s.getId(), 1);
        System.out.println(cart);
        System.out.println(pm);
        pm.removeProductFromCart(cart, s.getId(), 1);
        System.out.println(cart);
        System.out.println(pm);

    }
}
