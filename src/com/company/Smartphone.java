package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Smartphone extends Product {
    private String colour;
    private int batteryCapacity;
    private List<Electronics> accessories;

    public Smartphone(String name, BigDecimal price, int stock, String colour, int batteryCapacity, List<Electronics> accessories) {
        super(name, price, stock);
        this.colour = colour;
        this.batteryCapacity = batteryCapacity;
        this.accessories = accessories;
    }

    public Smartphone(String name, BigDecimal price, int stock, String colour, int batteryCapacity) {
        super(name, price, stock);
        this.colour = colour;
        this.batteryCapacity = batteryCapacity;
        this.accessories = new ArrayList<>();
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public List<Electronics> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Electronics> accessories) {
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Smartphone{");
        sb.append("id=").append(this.getId());
        sb.append(", name='").append(this.getName()).append('\'');
        sb.append(", price=").append(this.getPrice());
        sb.append(", stock=").append(this.getStock());
        sb.append(", colour='").append(colour).append('\'');
        sb.append(", batteryCapacity=").append(batteryCapacity);
        sb.append(", accessories=").append(accessories.toString());
        sb.append('}');
        return sb.toString();
    }
}
