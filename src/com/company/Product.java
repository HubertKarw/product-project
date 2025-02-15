package com.company;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.Locale;


public abstract class Product {
    private UUID id;
    private String name;
    private BigDecimal price;
    private int stock;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
        return name.toUpperCase(Locale.ROOT).equals(this.getName().toUpperCase(Locale.ROOT));
    }

    public boolean isIdEquals(UUID id) {
        return id == this.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if ((product.getPrice().compareTo(getPrice())) != 0) return false;
        return getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId().version();
        result = 31 * result + getName().hashCode();
        temp = getPrice().byteValue();
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Product(String name, BigDecimal price, int stock) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
