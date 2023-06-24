package com.learn.pattern.chain.of.responsibility.model;

import com.learn.pattern.chain.of.responsibility.intf.PurchasePower;

public class CEOPurchasePower extends PurchasePower {
    public CEOPurchasePower(PurchasePower successor) {
        super(successor);
    }

    @Override
    protected double getAllowable() {
        return BASE * 1000;
    }

    @Override
    protected String getRole() {
        return "CEO";
    }
}
