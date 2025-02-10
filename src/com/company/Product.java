package com.company;

public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int quantity) {
        if (this.getStock() < quantity) {
            throw new IllegalArgumentException("not enough productys in stock");
        } else {
            this.setStock(this.getStock() - quantity);
        }
    }

    public void increaseStock(int quantity) {
        this.setStock(this.getStock() + quantity);
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isNameEquals(String name) {
        return name.equals(this.getName());
    }

    public boolean isIdEquals(int id) {
        return id == this.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        return getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + getName().hashCode();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
