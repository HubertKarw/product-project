package com.company;

import java.util.Arrays;

public class Smartphone extends Product {
    String colour;
    int batteryCapacity;
    Electronics[] accessories;//lista

    public Smartphone(int id, String name, double price, int stock, String colour, int batteryCapacity, Electronics[] accessories) {
        super(id, name, price, stock);
        this.colour = colour;
        this.batteryCapacity = batteryCapacity;
        this.accessories = accessories;
    }

    public Smartphone(int id, String name, double price, int stock, String colour, int batteryCapacity) {
        super(id, name, price, stock);
        this.colour = colour;
        this.batteryCapacity = batteryCapacity;
        this.accessories= new Electronics[0];
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

    public Electronics[] getAccessories() {
        return accessories;
    }

    public void setAccessories(Electronics[] accessories) {
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
        sb.append(", accessories=").append(Arrays.toString(accessories));
        sb.append('}');
        return sb.toString();
    }
}
