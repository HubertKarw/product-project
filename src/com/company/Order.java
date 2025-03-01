package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Order {
    private Cart cart;
    private Client client;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;

    public Order(Cart cart) {
        this.cart = cart;
        this.client = cart.getClient();
        this.totalPrice = cart.totalPrice();
        this.orderDate = null;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void applyDiscount(BigDecimal discount) {
        if (discount.compareTo(BigDecimal.ONE) < 0) {
            throw new IllegalArgumentException("Discount cannot be more than 100%");
        }
        this.totalPrice = this.totalPrice.multiply(BigDecimal.ONE.subtract(discount)).setScale(2, RoundingMode.HALF_UP);
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void markOrderAsProcessed() {
        this.orderDate = LocalDateTime.now();
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
