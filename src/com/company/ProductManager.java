package com.company;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public Product findByName(String name) throws ProductNotInShopException {
        return products.stream()
                .filter(product -> product.isNameEquals(name))
                .limit(1)
                .findFirst()
                .orElseThrow(ProductNotInShopException::new);
    }

    public Product findByID(UUID id) throws ProductNotInShopException {
        return products.stream()
                .filter(product -> product.isIdEquals(id))
                .limit(1)
                .findFirst()
                .orElseThrow(ProductNotInShopException::new);
    }

    public void addProductToCart(Cart cart, UUID productId, int quantity) {
        Product product = null;
        try {
            product = findByID(productId);
        } catch (ProductNotInShopException e) {
            throw new ProductNotInShopException("there is no product with id:" + productId + "in shop | cant`t add product to cart");
        }
        Product cartProduct = product.clone();
        if (cart.isIdInCart(productId)) {
            cart.addQuantityInCart(this.findInCart(cart, productId), quantity);
        } else {
            cart.addToCart(cartProduct, quantity);
        }
        product.decreaseStock(quantity);
    }

    public void removeProductFromCart(Cart cart, UUID productId, int quantity) {
        Product product = null;
        try {
            product = findByID(productId);
        } catch (ProductNotInShopException e) {
            throw new ProductNotInShopException("there is no product with id:" + productId + "in shop");
        }
        if (cart.isIdInCart(productId)) {
            cart.removeQuantityInCart(this.findInCart(cart, productId), quantity);
            product.increaseStock(quantity);
        } else {
            throw new ProductNotInCartException("there is no product with id:" + productId + "in cart");
        }
    }

    public Product findInCart(Cart cart, UUID productId) {
        if (cart == null || cart.getProducts() == null) {
            throw new ProductNotInCartException("cart not prepared for adding products");
        }
        return cart.getProducts().stream()
                .filter(product -> product.isIdEquals(productId))
                .limit(1)
                .findFirst()
                .orElseThrow(ProductNotInCartException::new);
    }

    public void showProducts() {
        List<Product> products = this.getProducts();
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductManager{");
        sb.append("products=").append(products);
        sb.append('}');
        return sb.toString();
    }

}
