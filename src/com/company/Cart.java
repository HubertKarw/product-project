package com.company;

import java.util.List;
import java.util.function.Consumer;

public class Cart extends ProductManager{
    private String clientName;

    public Cart(List<Product> products, String clientName) {
        super(products);
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void placeOrder(){
        if (this.getProducts().isEmpty()) {
            System.out.println("your cart is empty");
        }else {
            this.getProducts()
                    .stream()
                    .forEach(this::sellProduct);
            System.out.println("your order has been placed");
            this.setProducts(java.util.Collections.emptyList());
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cart{");
        sb.append("clientName='").append(clientName).append('\'');
        sb.append("products= ").append(this.getProducts().toString());
        sb.append('}');
        return sb.toString();
    }
}
