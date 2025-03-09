package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;

public class Order {
    private Cart cart;
    private Client client;
    private BigDecimal totalPrice;
    private ZonedDateTime orderDate;

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
            throw new InvalidDiscountException("Discount cannot be more than 100%");
        }
        this.totalPrice = this.totalPrice.multiply(BigDecimal.ONE.subtract(discount)).setScale(2, RoundingMode.HALF_UP);
    }

    public ZonedDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(ZonedDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void markOrderAsProcessed() {
//        ZoneId zoneId = ZoneId.of("Australia/Sydney");
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime timeNow = LocalDateTime.now();
        this.orderDate = OffsetDateTime.of(timeNow, zoneId.getRules().getOffset(timeNow)).atZoneSameInstant(ZoneId.of("Europe/Warsaw"));
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
