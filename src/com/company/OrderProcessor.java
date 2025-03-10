package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * This is class for processing orders containing multi thread solution to process orders
 *
 * @author hubert_karw
 */
public class OrderProcessor extends Thread {
    private static final File file = new File("orders.txt");
    private Order orderToProcess;
    private String receipt;
    /**
     * ExecutorService that has thread pool of threads to process the orders
     */
    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    /**
     * This is constructor for Order processor that creates an object of OrderProcessor and then creates a file for receipts or if it exists does nothing.
     *
     * @param orderToProcess Order you wish to process
     */
    public OrderProcessor(Order orderToProcess) {
        this.orderToProcess = orderToProcess;
        this.receipt = null;
        createFile();
    }

    /**
     * Creates a receipt from the user specified order
     *
     * @return String with a receipt that has a local time of the user
     */
    public String createReceipt() {
        BigDecimal total = orderToProcess.getTotalPrice();
        String clientName = orderToProcess.getClient().getUsername();
        Cart cart = orderToProcess.getCart();
        StringBuilder sb = new StringBuilder("Client: '");
        sb.append(clientName).append("\'\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        sb.append("Order date: ").append(orderToProcess.getOrderDate().withZoneSameInstant(ZoneId.systemDefault()).format(formatter)).append("\n");
        sb.append("items:").append("\n");
        sb.append(cart
                .getProducts()
                .stream()
                .map(product -> (product.getId() + " " + product.getName() + "\t\t\t" + product.getPrice()
                        .multiply(BigDecimal.valueOf(product.getStock())).toPlainString() + "pln"))
                .collect(Collectors.joining("\n")));
        sb.append("\nTotal Price: ").append(total.toPlainString()).append("pln");
        this.receipt = sb.toString();
        return sb.toString();
    }

    public void process() {
        System.out.println(Thread.currentThread().getName() + ": current Thread");
        executor.execute(this::run);
    }

    public static synchronized void createFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException ioe) {
            System.out.println("Cannot create this file.");
            ioe.printStackTrace();
        }

    }

    @Override
    public void run() {
        orderToProcess.markOrderAsProcessed();
        String receipt = createReceipt();
        System.out.println(receipt);
        writeToFile(receipt);
        orderToProcess.getCart().placeOrder();
        orderToProcess.setTotalPrice(BigDecimal.ZERO);
        System.out.println(Thread.currentThread().getName() + ": finished");
        System.out.println(Thread.currentThread().getId() + ": finished");
    }

    public static synchronized void writeToFile(String receipt) {
        try {
            FileWriter myWriter = new FileWriter("orders.txt", true);
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
