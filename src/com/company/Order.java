package com.company;

import java.math.BigDecimal;

public class Order {
    private Cart cart;
    private String client;
    private BigDecimal totalPrice;

    public Order(Cart cart){
        this.cart = cart;
        this.client = cart.getClientName();
        this.totalPrice =cart.totalPrice();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("cart=").append(cart);
        sb.append(", client='").append(client).append('\'');
        sb.append(", totalPrice=").append(totalPrice);
        sb.append('}');
        return sb.toString();
    }
}
