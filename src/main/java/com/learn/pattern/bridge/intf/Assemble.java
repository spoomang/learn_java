package com.learn.pattern.bridge.intf;

public class Assemble implements WorkShop {
    @Override
    public void make() {
        System.out.println("Assembling workshop...");
    }
}
