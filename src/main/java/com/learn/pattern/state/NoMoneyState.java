package com.learn.pattern.state;

public class NoMoneyState implements State {
    SodaVendingMachine machine;

    public NoMoneyState(SodaVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("You inserted money!!");
        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void ejectMoney() {
        System.out.println("You haven't inserted a dollar");
    }

    @Override
    public void selectSoda() {
        System.out.println("You selected, but no money");
    }

    @Override
    public void ejectSoda() {
        System.out.println("You haven't paid yet");
    }
}
