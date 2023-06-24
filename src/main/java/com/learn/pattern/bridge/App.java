package com.learn.pattern.bridge;


import com.learn.pattern.bridge.intf.Assemble;
import com.learn.pattern.bridge.intf.Make;
import com.learn.pattern.bridge.model.Bike;
import com.learn.pattern.bridge.model.Car;
import com.learn.pattern.bridge.model.Vehicle;

public class App {
    public static void main(String[] args) {

        Vehicle car = new Car(new Make(), new Assemble());
        car.manufacture();

        Vehicle bike = new Bike(new Make(), new Assemble());
        bike.manufacture();

    }
}
