package com.company;

public class RandomAccessMemory {
    private String manufacturer;
    private int memory;
    private Unit unit;

    public RandomAccessMemory(String manufacturer, int memory, Unit unit) {
        this.manufacturer = manufacturer;
        this.memory = memory;
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RandomAccessMemory{");
        sb.append("manufacturer='").append(manufacturer).append('\'');
        sb.append(", memory=").append(memory);
        sb.append(", unit=").append(unit.getUnit());
        sb.append('}');
        return sb.toString();
    }
}
