package com.company;

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
    public void addToCart(Product product){
        if (product.getStock()>0){
            this.products.add(product);
        }else{
            throw new IllegalArgumentException("not enough in stock");
        }
    }
    public void removeFromCart(Product product){
        if(this.products.contains(product)){
            this.products.remove(product);
        }else{
            throw new IllegalArgumentException("no such product in cart");
        }
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cart{");
        sb.append("clientName='").append(client.getUsername()).append('\'');
        sb.append("clientAddres").append((client.getAddress())).append('\'');
        sb.append("products= ").append(this.getProducts().toString());
        sb.append('}');
        return sb.toString();
    }
}
