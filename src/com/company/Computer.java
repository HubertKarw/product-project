package com.company;

public class Computer extends Product {
    private String processor;
    private int ram;

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
