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
}
