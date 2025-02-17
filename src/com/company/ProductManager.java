package com.company;

import javax.management.AttributeNotFoundException;
import java.util.List;
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

    public void showProducts() {
        List<Product> products = this.getProducts();
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }
}
