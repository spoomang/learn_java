package com.algo.app.practice.memory.leak;

import java.util.ArrayList;
import java.util.List;

public class StaticTest {

     static List<Double> list = new ArrayList<>();
    
    void populate() {
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
        System.out.println("Debug Point 2");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Debug Point 1");
        new StaticTest().populate();
        System.out.println("Debug Point 3");

        Thread.sleep(1_000_000);
    }
}
