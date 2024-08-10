package com.learn.pattern.state;

public class HasMoneyState implements State{
    SodaVendingMachine machine;

    public HasMoneyState(SodaVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("No need to insert another money");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Returning money");
        machine.setState(machine.getNoMoneyState());
    }

    @Override
    public void selectSoda() {
        System.out.println("Selected Soda ....");
        machine.setState(machine.getSoldState());
    }

    @Override
    public void ejectSoda() {
        System.out.println("No soda dispensed");
    }
}
