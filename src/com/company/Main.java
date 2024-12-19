package com.company;

public class Main {

    public static void main(String[] args) {
        Product computer1 = new Computer(1,"Dell",123,100);
        Product computer2 = new Computer(1,"Dell",123,100);
        Product computer3 = new Computer(1,"Dell",123,100);
        Product electronics = new Electronics(20,"cable", 10, 1);
        Electronics[] accessories1 = {(Electronics) electronics};
        Product smartphone1 = new Smartphone(1,"samsung", 1000.1,10,"red", 1200);
        Product smartphone2 = new Smartphone(1,"samsung", 1000.1,10,"red", 1200, accessories1);
        System.out.println(smartphone1);
        System.out.println(smartphone2);
    }
}
