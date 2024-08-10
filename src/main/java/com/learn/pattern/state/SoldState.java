package com.learn.pattern.state;

public class SoldState implements State {
    SodaVendingMachine machine;

    public SoldState(SodaVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("wait soda is coming");
    }

    @Override
    public void ejectMoney() {
        System.out.println("sorry soda is coming");
    }

    @Override
    public void selectSoda() {
        System.out.println("you already selected");
    }

    @Override
    public void ejectSoda() {
        System.out.println("stop trying to get soda for free");
        if (machine.getCount() > 0) {
            machine.setState(machine.noMoneyState);
        } else {
            System.out.println("sold out");
            machine.setState(machine.getSoldOutState());
        }
    }
}
