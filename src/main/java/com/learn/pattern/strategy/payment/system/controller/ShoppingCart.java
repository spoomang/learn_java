package com.learn.pattern.strategy.payment.system.controller;

import com.learn.pattern.strategy.payment.system.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> products;

    public ShoppingCart() {
        this.products =  new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    private int calculatePrice() {
        int price = 0;

        for (Product p : products) {
            price += p.getPrice();
        }

        return price;
    }

    public void pay(Payment p) {
        int price = calculatePrice();
        p.pay(price);
    }

}
