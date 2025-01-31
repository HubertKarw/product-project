package com.company;

import java.util.List;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cart{");
        sb.append("clientName='").append(clientName).append('\'');
        sb.append("products= ").append(this.getProducts().toString());
        sb.append('}');
        return sb.toString();
    }
}
