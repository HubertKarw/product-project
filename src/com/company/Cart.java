package com.company;

import java.util.ArrayList;
import java.util.List;

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
//            if (product.getStock()>quantity){
//                throw new IllegalArgumentException("there is not enought of product with id:"+product.getId()+" in cart");
//            }
//            product.decreaseStock(quantity);
    }

    public void addQuantityInCart(Product product, int quantity) {
        product.increaseStock(quantity);
    }

    public void removeQuantityInCart(Product product, int quantity) {
        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("there is not enough of product with id:" + product.getId() + " in cart");
        }
        if (product.getStock() == quantity) {
            removeFromCart(product, quantity);
        } else {
            product.decreaseStock(quantity);
        }
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
