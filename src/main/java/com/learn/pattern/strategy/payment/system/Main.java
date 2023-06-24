package com.learn.pattern.strategy.payment.system;

import com.learn.pattern.strategy.payment.system.controller.ShoppingCart;
import com.learn.pattern.strategy.payment.system.model.CreditCardPayment;
import com.learn.pattern.strategy.payment.system.model.Product;

public class Main {

    public static void main(String[] args) {
        Product shirt = new Product("1", "kindi", 10);
        Product pants = new Product("2", "kundu", 20);
        Product wire = new Product("3", "frrr", 50);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(shirt);
        cart.addProduct(pants);
        cart.addProduct(wire);

        cart.pay(new CreditCardPayment());
    }
}
