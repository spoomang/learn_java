package com.learn.pattern.state;

public class SoldOutState implements State {
    SodaVendingMachine machine;

    public SoldOutState(SodaVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("sold out");
    }

    @Override
    public void ejectMoney() {
        System.out.println("sold out");
    }

    @Override
    public void selectSoda() {
        System.out.println("sold out");
    }

    @Override
    public void ejectSoda() {
        System.out.println("sold out");
    }
}
