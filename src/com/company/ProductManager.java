package com.company;

import java.util.List;

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

    public void addProduct(Product product){
        this.products.add(product);
    }
    public void removeProduct(Product product){
        this.products.remove(product);
    }
    public void sellProduct(Product product){
        if (this.products.contains(product)) {
            product.setStock(product.getStock()-1);
        }
    }

    public void ShowProducts(){
        List<Product> products = this.getProducts();
        for (Product p: products) {
            System.out.println(p.toString());
        }
    }
}
