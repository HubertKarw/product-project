package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class OrderProcessor {
    private static File file = new File("orders.txt");

    public static String createReceipt(Order orderToProcess) {
        BigDecimal total = orderToProcess.getTotalPrice();
        String clientName = orderToProcess.getClient().getUsername();
        Cart cart = orderToProcess.getCart();
        StringBuilder sb = new StringBuilder("Client: '");
        sb.append(clientName).append("\'\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        sb.append("Order date: ").append(orderToProcess.getOrderDate().format(formatter)).append("\n");
        sb.append("items:").append("\n");
        sb.append(cart
                .getProducts()
                .stream()
                .map(product -> (product.getId() + " " + product.getName() + "\t\t\t" + product.getPrice()
                        .multiply(BigDecimal.valueOf(product.getStock())).toPlainString() + "pln"))
                .collect(Collectors.joining("\n")));
        sb.append("\nTotal Price: ").append(total.toPlainString()).append("pln");
        return sb.toString();
    }

    public static void process(Order orderToProcess) {
        orderToProcess.markOrderAsProcessed();
        String receipt = createReceipt(orderToProcess);
        System.out.println(receipt);
        createFile();
        writeToFile(receipt);
        orderToProcess.getCart().placeOrder();
        orderToProcess.setTotalPrice(BigDecimal.ZERO);
    }
    public static void createFile(){
        try{
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }else{
                System.out.println("File already exists");
            }
        }catch (IOException ioe){
            System.out.println("Cannot create this file.");
            ioe.printStackTrace();
        }

    }
    public static void writeToFile(String receipt){
        try {
            FileWriter myWriter = new FileWriter("orders.txt",true);
            myWriter.append(receipt);
            myWriter.append("\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ioe) {
            System.out.println("Cannot write to this file.");
            ioe.printStackTrace();
        }
    }
}
