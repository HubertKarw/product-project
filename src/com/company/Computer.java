package com.company;

import java.math.BigDecimal;
import java.util.UUID;

public class Computer extends Product {
    private Processor processor;
    private RandomAccessMemory ram;

    public Computer(String name, BigDecimal price, int stock) {
        super(name, price, stock);
    }

    @Override
    public Product clone() {
        return new Computer(this.getId(),this.getName(),this.getPrice(),0,this.processor,this.ram);
    }

    public Computer(UUID id, String name, BigDecimal price, int stock, Processor processor, RandomAccessMemory ram) {
        super(id, name, price, stock);
        this.processor = processor;
        this.ram = ram;
    }

    public Computer(String name, BigDecimal price, int stock, Processor processor, RandomAccessMemory ram) {
        super(name, price, stock);
        this.processor = processor;
        this.ram = ram;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RandomAccessMemory getRam() {
        return ram;
    }

    public void setRam(RandomAccessMemory ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Computer{");
        sb.append("processor='").append(processor).append('\'');
        sb.append(", ram=").append(ram);
        sb.append(", id=").append(this.getId());
        sb.append(", name='").append(this.getName()).append('\'');
        sb.append(", price=").append(this.getPrice());
        sb.append(", stock=").append(this.getStock());
        sb.append('}');
        return sb.toString();
    }
}
