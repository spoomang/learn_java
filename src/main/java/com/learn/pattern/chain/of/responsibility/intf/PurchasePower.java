package com.learn.pattern.chain.of.responsibility.intf;

import com.learn.pattern.chain.of.responsibility.model.PurchaseRequest;

public abstract class PurchasePower {
    protected static double BASE = 10.0;
    protected PurchasePower successor;

    abstract protected double getAllowable();
    abstract protected String getRole();

    public PurchasePower(PurchasePower successor) {
        this.successor = successor;
    }

    public void purchase(PurchaseRequest request) {
        if (request.getAmount() < getAllowable()) {
            System.out.printf("This request is approved by %s for amount %f for the purpose of %s\n", getRole(), request.getAmount(), request.getPurpose());
        } else if (successor != null) {
            successor.purchase(request);
        } else {
            System.out.println("Cannot be processed");
        }
    }
}
