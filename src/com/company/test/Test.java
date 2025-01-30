package com.company.test;

import com.company.*;

import java.util.ArrayList;
import java.util.List;

public class Test{
    public static void task1Test(){
//        creating products
        Product computer1 = new Computer(1,"Dell",123,100);
        Product computer2 = new Computer(1,"Dell",123,100);
        Product computer3 = new Computer(1,"Dell",123,100);
        Product electronics = new Electronics(20,"cable", 10, 1);
        Electronics[] accessories1 = {(Electronics) electronics};
        Product smartphone1 = new Smartphone(1,"samsung", 1000.1,10,"red", 1200);
        Product smartphone2 = new Smartphone(1,"samsung", 1000.1,10,"red", 1200, accessories1);
//        printing created products
        System.out.println(computer1);
        System.out.println(computer2);
        System.out.println(computer3);
        System.out.println(electronics);
        System.out.println(smartphone1);
        System.out.println(smartphone2);
    }
    public static void task2Test(){
//        creating products and adding them to product manager
        Product computer1 = new Computer(1,"Dell",123,100);
        Product computer2 = new Computer(1,"Dell",123,100);
        Product computer3 = new Computer(1,"Dell",123,100);
        Product electronics = new Electronics(20,"cable", 10, 1);
        Electronics[] accessories1 = {(Electronics) electronics};
        Product smartphone1 = new Smartphone(1,"samsung", 1000.1,10,"red", 1200);
        Product smartphone2 = new Smartphone(1,"samsung", 1000.1,10,"red", 1200, accessories1);
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1,computer2,computer3,electronics,smartphone1));
        ProductManager manager = new ProductManager(products);
        manager.showProducts();
        manager.addProduct(smartphone2);
        manager.showProducts();
        manager.removeProduct(smartphone1);
        manager.showProducts();
        manager.sellProduct(computer1);
        manager.showProducts();
    }
}
