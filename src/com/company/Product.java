package com.company;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.Locale;


public abstract class Product implements Cloneable {
    private UUID id;
    private String name;
    private BigDecimal price;
    private int stock;

    public Product(String name, BigDecimal price, int stock) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(UUID id, String name, BigDecimal price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

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
            throw new ProductNotInShopException("not enough products in stock");
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
        return id.equals(this.getId());
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

    @Override
    public abstract Product clone();


}
