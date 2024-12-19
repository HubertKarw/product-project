package com.company;

public class Computer extends Product {
    String processor;
    int ram;

    public Computer(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
