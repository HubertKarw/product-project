package com.company;

import javax.management.AttributeNotFoundException;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    //metoda do szukania po nazwie
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
            product.decreaseStock(1);
        }
    }
    public Product findByName(String name) throws AttributeNotFoundException {
        return products.stream()
                .filter(product -> product.isNameEquals(name))
                .limit(1)
                .findFirst()
                .orElseThrow(AttributeNotFoundException::new);
    }
    public Product findByID(int id){
        return null;
    }

    public void showProducts() {
        List<Product> products = this.getProducts();
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }
}
