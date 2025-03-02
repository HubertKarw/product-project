package com.company;


import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

public class Cart {
    private List<Product> products;
    private Client client;

    public Cart(List<Product> products, Client client) {
        this.products = products;
        this.client = client;
    }

    public Cart(Client client) {
        this.client = client;
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addToCart(Product product, int quantity) {
        this.products.add(product);
        product.increaseStock(quantity);
    }

    public void removeFromCart(Product product, int quantity) {
        this.products.remove(product);
    }

    public void addQuantityInCart(Product product, int quantity) {
        product.increaseStock(quantity);
    }

    public void removeQuantityInCart(Product product, int quantity) {
        if (product.getStock() < quantity) {
            throw new ProductNotInCartException("there is not enough of product with id:" + product.getId() + " in cart");
        }
        if (product.getStock() == quantity) {
            removeFromCart(product, quantity);
        } else {
            product.decreaseStock(quantity);
        }
    }

    public boolean isIdInCart(UUID id) {
        return this.getProducts().stream()
                .anyMatch(product -> product.getId().equals(id));
    }

    public void placeOrder() {
        if (this.getProducts().isEmpty()) {
            throw new ProductNotInCartException("your order cannot be placed | no products in cart");
        } else {
//            this.getProducts()
//                    .stream()
//                    .collect(Collectors.toMap(Product::getId, Product::getStock))
//                    .forEach((k, v) -> System.out.println("id: " + k + " stock: " + v));
            System.out.println("your order has been placed");
            this.setProducts(new ArrayList<Product>());
        }
    }

    public BigDecimal totalPrice() {
        return this.getProducts()
                .stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getStock())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cart{");
        sb.append("clientName='").append(client.getUsername()).append('\'');
        sb.append("products= ").append(this.getProducts().toString());
        sb.append('}');
        return sb.toString();
    }
}
