package com.company;

public enum Unit {
    B("Bytes"), KB("Kilobytes"), MB("Megabytes"), GB("Gigabytes"), TB("Terabytes");
    private final String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
