package com.learn.pattern.bridge.model;

import com.learn.pattern.bridge.intf.WorkShop;

public class Car extends Vehicle {
    public Car(WorkShop workShop1, WorkShop workShop2) {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing Car...");
        workShop1.make();
        workShop2.make();
    }
}
