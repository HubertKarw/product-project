package com.company.test;

import com.company.*;

import javax.management.AttributeNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void task1Test() {
//        creating products
        Processor processor = new Processor("Intel", 6, 40000);
        RandomAccessMemory ram = new RandomAccessMemory("Kingstone", 16, Unit.GB);
        Product computer1 = new Computer("Dell", 123, 100, processor, ram);
        Product computer2 = new Computer("Dell", 123, 100);
        Product computer3 = new Computer("Dell", 123, 100);
        ;
        Product electronics = new Electronics("cable", 10, 1);
        List<Electronics> accessories1 = new ArrayList<>();
        accessories1.add((Electronics) electronics);
        Product smartphone1 = new Smartphone("samsung", 1000.1, 10, "red", 1200);
        Product smartphone2 = new Smartphone("samsung", 1000.1, 10, "red", 1200, accessories1);
//        printing created products
        System.out.println(computer1);
        System.out.println(computer2);
        System.out.println(computer3);
        System.out.println(electronics);
        System.out.println(smartphone1);
        System.out.println(smartphone2);
    }

    public static void processorTest() {
        Processor processor = new Processor("Intel", 8, 34000);
        System.out.println(processor);
    }

    public static void ramTest() {
        RandomAccessMemory ram = new RandomAccessMemory("Kingstone", 8, Unit.GB);
        System.out.println(ram);
    }

    public static void task2Test() {
//        creating products and adding them to product manager
        Product computer1 = new Computer("Dell", 123, 100);
        Product computer2 = new Computer("Dell", 123, 100);
        Product computer3 = new Computer("Dell", 123, 100);
        Product electronics = new Electronics("cable", 10, 1);
        List<Electronics> accessories1 = new ArrayList<>();
        accessories1.add((Electronics) electronics);
        Product smartphone1 = new Smartphone("samsung", 1000.1, 10, "red", 1200);
        Product smartphone2 = new Smartphone("samsung", 1000.1, 10, "red", 1200, accessories1);
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3, electronics, smartphone1));
        ProductManager manager = new ProductManager(products);
        manager.showProducts();
        manager.addProduct(smartphone2);
        manager.showProducts();
        manager.removeProduct(smartphone1);
        manager.showProducts();
        manager.sellProduct(computer1);
        manager.showProducts();
    }

    public static void findByIdAndNameTest() {
        Processor processor = new Processor("Intel", 6, 40000);
        RandomAccessMemory ram = new RandomAccessMemory("Kingstone", 16, Unit.GB);
        Product computer1 = new Computer("Dell", 123, 100, processor, ram);
        Product computer2 = new Computer("Dell", 123, 100);
        Product computer3 = new Computer("Dell", 123, 100);
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3));
        ProductManager manager = new ProductManager(products);
        try {
            System.out.println(manager.findByName("dell"));
        } catch (AttributeNotFoundException e) {
            e.printStackTrace();
        }

    }
}
