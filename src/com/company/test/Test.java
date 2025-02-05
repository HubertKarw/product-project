package com.company.test;

import com.company.*;

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
    public static void processorTest(){
        Processor processor = new Processor("Intel",8,34000);
        System.out.println(processor);
    }
    public static void ramTest(){
        RandomAccessMemory ram = new RandomAccessMemory("Kingstone",8,Unit.GB);
        System.out.println(ram);
    }
}
