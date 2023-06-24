package com.learn.pattern.decorator.model;

import com.learn.pattern.decorator.interfaces.IceCream;

public class BasicIceCream implements IceCream {

    @Override
    public double cost() {
        return 0.50;
    }
}
