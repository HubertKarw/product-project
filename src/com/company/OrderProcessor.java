package com.company;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class OrderProcessor {
    private Order orderToProcess;

    public OrderProcessor(Order order){
        this.orderToProcess = order;
    }
    public String createReceipt(){
        BigDecimal total = orderToProcess.getTotalPrice();
        String clientName= orderToProcess.getClient();
        Cart cart = orderToProcess.getCart();
        StringBuilder sb = new StringBuilder("Client: '");
        sb.append(clientName).append("\'\n");
        sb.append("items:").append("\n");
        sb.append(cart
                .getProducts()
                .stream()
                .map(product -> (product.getId() +" "+product.getName()+"\t\t\t"+ product.getPrice().toPlainString()+"pln"))
                .collect(Collectors.joining("\n")));
        sb.append("Total Price: ").append(total.toPlainString()).append("pln");
        return sb.toString();
    }
    public void process(){
        System.out.println(this.createReceipt());
        orderToProcess.getCart().placeOrder();
    }
}
