package com.learn.pattern.chain.of.responsibility.model;

import com.learn.pattern.chain.of.responsibility.intf.PurchasePower;

public class DirectorPurchasePower extends PurchasePower {
    public DirectorPurchasePower(PurchasePower successor) {
        super(successor);
    }

    @Override
    protected double getAllowable() {
        return BASE * 100;
    }

    @Override
    protected String getRole() {
        return "DIRECTOR";
    }
}
