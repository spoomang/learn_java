package com.learn.pattern.bridge.model;

import com.learn.pattern.bridge.intf.WorkShop;

public class Bike extends Vehicle {
    public Bike(WorkShop workShop1, WorkShop workShop2) {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing Bike...");
        workShop1.make();
        workShop2.make();
    }
}
