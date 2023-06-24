package com.learn.pattern.bridge.intf;

public class Make implements WorkShop {
    @Override
    public void make() {
        System.out.println("Making in the workshop");
    }
}
