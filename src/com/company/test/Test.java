package com.company.test;

import com.company.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void creatingAndCheckingCorrectDisplayOfAllProducts() {
//        creating products
        Processor processor = new Processor("Intel", 6, 40000);
        RandomAccessMemory ram = new RandomAccessMemory("Kingstone", 16, Unit.GB);
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(120), 100, processor, ram);
        Product computer2 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        Product computer3 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        ;
        Product electronics = new Electronics("cable", BigDecimal.valueOf(120), 1);
        List<Electronics> accessories1 = new ArrayList<>();
        accessories1.add((Electronics) electronics);
        Product smartphone1 = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200);
        Product smartphone2 = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200, accessories1);
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
}
