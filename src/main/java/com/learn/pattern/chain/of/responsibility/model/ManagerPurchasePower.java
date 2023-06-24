package com.learn.pattern.chain.of.responsibility.model;

import com.learn.pattern.chain.of.responsibility.intf.PurchasePower;

public class ManagerPurchasePower extends PurchasePower {
    public ManagerPurchasePower(PurchasePower successor) {
        super(successor);
    }

    @Override
    protected double getAllowable() {
        return BASE * 10;
    }

    @Override
    protected String getRole() {
        return "MANAGER";
    }
}
