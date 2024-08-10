package com.learn.pattern.state;

public class SodaVendingMachine {
    State state;
    State noMoneyState, hasMoneyState, soldOutState, soldState;
    int count = 0;

    public SodaVendingMachine(int count) {
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);

        this.count = count;

        if (count > 0) {
            state = noMoneyState;
        }
    }

    public void insertMoney() {
        state.insertMoney();
    }

    public void ejectMoney() {
        state.ejectMoney();
    }

    public void selectSoda() {
        state.selectSoda();
    }

    public void ejectSoda() {
        state.ejectSoda();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getNoMoneyState() {
        return noMoneyState;
    }

    public void setNoMoneyState(State noMoneyState) {
        this.noMoneyState = noMoneyState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public void setHasMoneyState(State hasMoneyState) {
        this.hasMoneyState = hasMoneyState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
