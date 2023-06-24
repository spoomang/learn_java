package com.learn.pattern.decorator;

import com.learn.pattern.decorator.interfaces.IceCream;
import com.learn.pattern.decorator.model.BasicIceCream;
import com.learn.pattern.decorator.model.ChocolateIceCream;
import com.learn.pattern.decorator.model.VanilaIceCream;

public class App {
    public static void main(String[] args) {

        IceCream iceCream = new BasicIceCream();
        System.out.println("Basic Ice cream cost : "+iceCream.cost());


        iceCream = new VanilaIceCream(new BasicIceCream());
        System.out.println("Vanila Ice cream cost : "+iceCream.cost());

        iceCream = new ChocolateIceCream(new BasicIceCream());
        System.out.println("Chocolate Ice cream cost : "+iceCream.cost());
    }
}
