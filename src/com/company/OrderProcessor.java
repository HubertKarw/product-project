package com.company;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class OrderProcessor {

    public static String createReceipt(Order orderToProcess) {
        BigDecimal total = orderToProcess.getTotalPrice();
        String clientName = orderToProcess.getClient().getUsername();
        Cart cart = orderToProcess.getCart();
        StringBuilder sb = new StringBuilder("Client: '");
        sb.append(clientName).append("\'\n");
        sb.append("items:").append("\n");
        sb.append(cart
                .getProducts()
                .stream()
                .map(product -> (product.getId() + " " + product.getName() + "\t\t\t" + product.getPrice().multiply(BigDecimal.valueOf(product.getStock())).toPlainString() + "pln"))
                .collect(Collectors.joining("\n")));
        sb.append("\nTotal Price: ").append(total.toPlainString()).append("pln");
        return sb.toString();
    }

    public static void process(Order orderToProcess) {
        System.out.println(createReceipt(orderToProcess));
        orderToProcess.getCart().placeOrder();
        orderToProcess.setTotalPrice(BigDecimal.ZERO);
    }
}
