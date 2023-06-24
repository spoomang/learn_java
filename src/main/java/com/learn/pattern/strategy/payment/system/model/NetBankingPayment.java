package com.learn.pattern.strategy.payment.system.model;

import com.learn.pattern.strategy.payment.system.controller.Payment;

public class NetBankingPayment implements Payment  {

    @Override
    public void pay(int amount) {
        System.out.println("pay "+amount + " using NetBankingPayment");
    }
}
