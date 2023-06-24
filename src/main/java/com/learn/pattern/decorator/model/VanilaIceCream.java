package com.learn.pattern.decorator.model;

import com.learn.pattern.decorator.interfaces.IceCream;

public class VanilaIceCream extends  IceCreamDecorator {

    public VanilaIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double cost() {
        return 1.0 + super.cost();
    }
}
