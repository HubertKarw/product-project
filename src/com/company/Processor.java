package com.company;

public class Processor {
    private String manufacturer;
    private int core;
    private double clockSpeed;

    public Processor(String manufacturer, int core, double clockSpeed) {
        this.manufacturer = manufacturer;
        this.core = core;
        this.clockSpeed = clockSpeed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public double getClockSpeed() {
        return this.clockSpeed;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Processor{");
        sb.append("manufacturer='").append(manufacturer).append('\'');
        sb.append(", core=").append(core);
        sb.append(", clockSpeed=").append(clockSpeed);
        sb.append('}');
        return sb.toString();
    }
}
