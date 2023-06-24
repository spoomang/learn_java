package com.learn.pattern.decorator.model;

import com.learn.pattern.decorator.interfaces.IceCream;

public class ChocolateIceCream extends IceCreamDecorator {

    public ChocolateIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double cost() {
        return 2.0 + super.cost();
    }
}
