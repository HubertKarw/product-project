package com.company;

import javax.management.AttributeNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ProductManager {
    private List<Product> products;

    public ProductManager(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public void sellProduct(Product product) {
        if (this.products.contains(product)) {
            System.out.println(product);
        }
    }

    public Product findByName(String name) throws AttributeNotFoundException {
        return products.stream()
                .filter(product -> product.isNameEquals(name))
                .limit(1)
                .findFirst()
                .orElseThrow(AttributeNotFoundException::new);
    }

    public Product findByID(UUID id) throws AttributeNotFoundException {
        return products.stream()
                .filter(product -> product.isIdEquals(id))
                .limit(1)
                .findFirst()
                .orElseThrow(AttributeNotFoundException::new);
    }
    public void addProductToCart(Cart cart, UUID productId, int quantity){
        //sprawdzic czy produkt isnieje
        Product product = null;
        Product cartProduct = null;
        try {
            product = findByID(productId);
            //cartProduct = new Product(productId,product.getName(),product.getPrice(),1);
            cartProduct = product.clone();
            cartProduct.setStock(quantity);

        } catch (AttributeNotFoundException | CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //dodanie rpoduktu do cart
        if(!Objects.isNull(product)){
//            UUID p =cart.getProducts().stream()
//                    .map(Product::getId)
//                    .filter(id-> id.equals(productId))
//                    .findFirst().orElseThrow();
            cart.addToCart(product);
        }
        //uSUNAC PRODUCT Z PRODUCT MANAGFE STOCK--
    }
    public void  removeProductFromCart(Cart cart, UUID productId){
        Product product = null;
        try {
            product = findByID(productId);
        } catch (AttributeNotFoundException e) {
            e.printStackTrace();
        }
        if(!Objects.isNull(product)){
            cart.removeFromCart(product);
        }
        //sprawdz czy produkt jest w carcie usuńz cart

    }

    public void showProducts() {
        List<Product> products = this.getProducts();
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }
}
