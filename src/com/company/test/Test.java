package com.company.test;

import com.company.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class Test {
    public static void creatingAndCheckingCorrectDisplayOfAllProducts() {
//        creating products
        Processor processor = new Processor("Intel", 6, 40000);
        RandomAccessMemory ram = new RandomAccessMemory("Kingstone", 16, Unit.GB);
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(120), 100, processor, ram);
        Product computer2 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        Product computer3 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        ;
        Product electronics = new Electronics("cable", BigDecimal.valueOf(120), 1);
        List<Electronics> accessories1 = new ArrayList<>();
        accessories1.add((Electronics) electronics);
        Product smartphone1 = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200);
        Product smartphone2 = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200, accessories1);
//        printing created products
        System.out.println(computer1);
        System.out.println(computer2);
        System.out.println(computer3);
        System.out.println(electronics);
        System.out.println(smartphone1);
        System.out.println(smartphone2);
    }

    public static void processorTest() {
        Processor processor = new Processor("Intel", 8, 34000);
        System.out.println(processor);
    }

    public static void ramTest() {
        RandomAccessMemory ram = new RandomAccessMemory("Kingstone", 8, Unit.GB);
        System.out.println(ram);
    }

    public static void addingAndRemovingProductsToProductManager() {
//        creating products and adding them to product manager
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        Product computer2 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        Product computer3 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        Product electronics = new Electronics("cable", BigDecimal.valueOf(120), 1);
        List<Electronics> accessories1 = new ArrayList<>();
        accessories1.add((Electronics) electronics);
        Product smartphone1 = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200);
        Product smartphone2 = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200, accessories1);
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3, electronics, smartphone1));
        ProductManager manager = new ProductManager(products);
        manager.showProducts();
        manager.addProduct(smartphone2);
        manager.showProducts();
        manager.removeProduct(smartphone1);
        manager.showProducts();
        manager.sellProduct(computer1);
        manager.showProducts();
    }

    public static void findByNameTest() {
        Processor processor = new Processor("Intel", 6, 40000);
        RandomAccessMemory ram = new RandomAccessMemory("Kingstone", 16, Unit.GB);
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(120), 100, processor, ram);
        Product computer2 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        Product computer3 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3));
        ProductManager manager = new ProductManager(products);
        try {
            System.out.println(manager.findByName("dell"));
        } catch (ProductNotInShopException e) {
            e.printStackTrace();
        }

    }

    public static void creatingCartAndPrintingInformation() {
        Processor processor = new Processor("Intel", 6, 40000);
        RandomAccessMemory ram = new RandomAccessMemory("Kingstone", 16, Unit.GB);
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(120), 100, processor, ram);
        Product computer2 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        Product computer3 = new Computer("Dell", BigDecimal.valueOf(120), 100);
        Product electronics = new Electronics("cable", BigDecimal.valueOf(120), 1);
        List<Electronics> accessories1 = new ArrayList<>();
        accessories1.add((Electronics) electronics);
        Product smartphone1 = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200);
        Product smartphone2 = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200, accessories1);
        Client client = new Client("123", "222");
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3, electronics, smartphone1));
        Cart cart = new Cart(products, client);
        System.out.println(cart);
    }

    public static void creatingClient() {
        Client client1 = new Client("username", "address");
        System.out.println(client1);
    }

    public static void addAndRemoveItemsToCart() {
        Client client = new Client("123", "123");
        Smartphone s = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200);
        Smartphone s1 = new Smartphone("samsungg", BigDecimal.valueOf(1201), 11, "red", 1200);
        Cart cart = new Cart(client);
        List<Product> products = new ArrayList<>(List.of(s, s1));
        ProductManager pm = new ProductManager(products);
        pm.addProductToCart(cart, s.getId(), 1);
        System.out.println(cart);
        System.out.println(pm);
        pm.addProductToCart(cart, s.getId(), 1);
        System.out.println(cart);
        System.out.println(pm);
        pm.removeProductFromCart(cart, s.getId(), 1);
        System.out.println(cart);
        System.out.println(pm);
        pm.removeProductFromCart(cart, s.getId(), 1);
        System.out.println(cart);
        System.out.println(pm);
    }

    public static void removeMoreItemsFromCart() {
        try {
            Client client = new Client("123", "123");
            Smartphone s = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200);
            Smartphone s1 = new Smartphone("samsungg", BigDecimal.valueOf(1201), 11, "red", 1200);
            Cart cart = new Cart(client);
            List<Product> products = new ArrayList<>(List.of(s, s1));
            ProductManager pm = new ProductManager(products);
            pm.addProductToCart(cart, s.getId(), 1);
            System.out.println(cart);
            System.out.println(pm);
            pm.addProductToCart(cart, s.getId(), 1);
            System.out.println(cart);
            System.out.println(pm);
            pm.removeProductFromCart(cart, s.getId(), 1);
            System.out.println(cart);
            System.out.println(pm);
            pm.removeProductFromCart(cart, s.getId(), 1);
            System.out.println(cart);
            System.out.println(pm);
            pm.removeProductFromCart(cart, s.getId(), 1);
            System.out.println(cart);
            System.out.println(pm);
        } catch (Exception e) {
            System.out.println("exception was thrown");
        }
    }

    public static void addOverStockToCart() {
        try {
            Client client = new Client("123", "123");
            Smartphone s = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200);
            Smartphone s1 = new Smartphone("samsungg", BigDecimal.valueOf(1201), 11, "red", 1200);
            Cart cart = new Cart(client);
            List<Product> products = new ArrayList<>(List.of(s, s1));
            ProductManager pm = new ProductManager(products);
            pm.addProductToCart(cart, s.getId(), 12);
            System.out.println(cart);
            System.out.println(pm);
        } catch (Exception e) {
            System.out.println("Exception caughts");
        }

    }

    public static void orderCart() {
        Client client = new Client("123", "123");
        Smartphone s = new Smartphone("samsung", BigDecimal.valueOf(120), 10, "red", 1200);
        Smartphone s1 = new Smartphone("samsungg", BigDecimal.valueOf(1201), 11, "red", 1200);
        Cart cart = new Cart(client);
        List<Product> products = new ArrayList<>(List.of(s, s1));
        ProductManager pm = new ProductManager(products);
        pm.addProductToCart(cart, s.getId(), 2);
        pm.addProductToCart(cart, s1.getId(), 3);
        cart.placeOrder();
        System.out.println(cart);
        System.out.println(products);
    }

    public static void creatingOrder() {
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(123), 100);
        Product computer2 = new Computer("Lenovo", BigDecimal.valueOf(122), 90);
        Product computer3 = new Computer("MacBook", BigDecimal.valueOf(500), 20);
        Client client = new Client("123", "123");
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3));
        Cart cart = new Cart(products, client);
        Order order = new Order(cart);
        System.out.println(order);
    }

    public static void processingOrder() {
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(123), 100);
        Product computer2 = new Computer("Lenovo", BigDecimal.valueOf(122), 90);
        Product computer3 = new Computer("MacBook", BigDecimal.valueOf(500), 20);
        Client client = new Client("123", "123");
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3));
        ProductManager pm = new ProductManager(products);
        Cart cart = new Cart(client);
        pm.addProductToCart(cart, computer2.getId(), 10);
        pm.addProductToCart(cart, computer2.getId(), 10);
        pm.addProductToCart(cart, computer1.getId(), 10);
        Order order = new Order(cart);
        System.out.println(order);
//        OrderProcessor processor = new OrderProcessor(order);
        OrderProcessor op = new OrderProcessor(order);
        op.process();
        System.out.println(computer1);
        System.out.println(computer2);
        System.out.println(cart);

    }

    public static void commandLineImplementationTesting() {
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(123), 100);
        Product computer2 = new Computer("Lenovo", BigDecimal.valueOf(122), 90);
        Product computer3 = new Computer("MacBook", BigDecimal.valueOf(500), 20);
        Client client = new Client("123", "123");
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3));
        ProductManager pm = new ProductManager(products);
        Cart cart = new Cart(client);
//        pm.addProductToCart(cart,computer1.getId(),1);
        CommandLineImpl cml = new CommandLineImpl();
        cml.printCart(cart);
        cml.printProducts(pm);
        cml.addToCart(pm, cart);
        cml.printCart(cart);
        cml.removeFromCart(pm, cart);
        cml.printCart(cart);
        Order order = cml.createOrder(cart);
        cml.printOrder(order);
        cml.printProducts(pm);
        cml.processOrder(order);
        cml.printCart(cart);
        cml.printOrder(order);
        cml.printProducts(pm);

    }
    public static void multipleOrdersAtTheSameTime(){
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(123), 100);
        Product computer2 = new Computer("Lenovo", BigDecimal.valueOf(122), 90);
        Product computer3 = new Computer("MacBook", BigDecimal.valueOf(500), 20);
        Client client = new Client("123", "123");
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3));
        ProductManager pm = new ProductManager(products);
        Cart cart1 = new Cart(client);
        Cart cart2 = new Cart(client);
        Cart cart3 = new Cart(client);
        Cart cart4 = new Cart(client);
        Cart cart5 = new Cart(client);
        Cart cart6 = new Cart(client);
        Cart cart7 = new Cart(client);
        pm.addProductToCart(cart1,computer1.getId(),12);
        pm.addProductToCart(cart1,computer3.getId(),2);
        pm.addProductToCart(cart2,computer1.getId(),21);
        pm.addProductToCart(cart3,computer1.getId(),9);
        pm.addProductToCart(cart4,computer1.getId(),1);
        pm.addProductToCart(cart4,computer2.getId(),1);
        pm.addProductToCart(cart5,computer1.getId(),1);
        pm.addProductToCart(cart5,computer2.getId(),1);
        pm.addProductToCart(cart6,computer1.getId(),1);
        pm.addProductToCart(cart6,computer2.getId(),1);
        pm.addProductToCart(cart7,computer1.getId(),1);
        pm.addProductToCart(cart7,computer2.getId(),1);
        Order order1 = new Order(cart1);
        Order order2 = new Order(cart2);
        Order order3 = new Order(cart3);
        Order order4 = new Order(cart4);
        Order order5 = new Order(cart5);
        Order order6 = new Order(cart6);
        Order order7 = new Order(cart7);
        OrderProcessor orderProcessor1 = new OrderProcessor(order1);
        OrderProcessor orderProcessor2 = new OrderProcessor(order2);
        OrderProcessor orderProcessor3 = new OrderProcessor(order3);
        OrderProcessor orderProcessor4 = new OrderProcessor(order4);
        OrderProcessor orderProcessor5 = new OrderProcessor(order5);
        OrderProcessor orderProcessor6 = new OrderProcessor(order6);
        OrderProcessor orderProcessor7 = new OrderProcessor(order7);
        orderProcessor1.process();
        orderProcessor2.process();
        orderProcessor3.process();
        orderProcessor4.process();
        orderProcessor5.process();
        orderProcessor6.process();
        orderProcessor7.process();
    }
    public static void ordersFromDifferentTimeZones() throws InterruptedException {
        Product computer1 = new Computer("Dell", BigDecimal.valueOf(123), 100);
        Product computer2 = new Computer("Lenovo", BigDecimal.valueOf(122), 90);
        Product computer3 = new Computer("MacBook", BigDecimal.valueOf(500), 20);
        Client client = new Client("123", "123");
        List<Product> products = new ArrayList<>();
        products.addAll(List.of(computer1, computer2, computer3));
        ProductManager pm = new ProductManager(products);
        Cart cart1 = new Cart(client);
        Cart cart2 = new Cart(client);
        Cart cart3 = new Cart(client);
        Cart cart4 = new Cart(client);
        pm.addProductToCart(cart1,computer1.getId(),12);
        pm.addProductToCart(cart1,computer3.getId(),2);
        pm.addProductToCart(cart2,computer1.getId(),21);
        pm.addProductToCart(cart3,computer1.getId(),9);
        pm.addProductToCart(cart4,computer1.getId(),1);
        pm.addProductToCart(cart4,computer2.getId(),1);
        Order order1 = new Order(cart1);
        Order order2 = new Order(cart2);
        Order order3 = new Order(cart3);
        Order order4 = new Order(cart4);
        OrderProcessor orderProcessor1 = new OrderProcessor(order1);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("------------------------------------------time now:" + ZonedDateTime.now());
        OrderProcessor orderProcessor2 = new OrderProcessor(order2);
        TimeZone.setDefault(TimeZone.getTimeZone("Australia/Sydney"));
        System.out.println("------------------------------------------time now:" + ZonedDateTime.now());
        OrderProcessor orderProcessor3 = new OrderProcessor(order3);
        TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
        System.out.println("------------------------------------------time now:" + ZonedDateTime.now());
        OrderProcessor orderProcessor4 = new OrderProcessor(order4);
        orderProcessor1.process();
        orderProcessor2.process();
        orderProcessor3.process();
        orderProcessor4.process();
        Thread.sleep(100);
        System.out.println(order1.getOrderDate());
        System.out.println(order2.getOrderDate());
        System.out.println(order3.getOrderDate());
        System.out.println(order4.getOrderDate());
        System.out.println("endofcode");
    }
}
