package com.company;

public class Computer extends Product {
    private Processor processor;
    private RandomAccessMemory ram;

    public Computer(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }
    public Computer(int id, String name, double price, int stock,Processor processor, RandomAccessMemory ram) {
        super(id, name, price, stock);
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
