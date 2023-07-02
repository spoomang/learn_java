package com.professional.certification.practice.thread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class MyThread1 implements Runnable {
    private String str;

    public MyThread1(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        System.out.println(str.toUpperCase());
    }
}

class Printer implements Callable<String> {
    @Override
    public String  call() {
        System.out.println("Done");
        return null;
    }
}

public class Test3 {
    public static void main(String[] args) throws Exception{
//        ExecutorService e = Executors.newSingleThreadExecutor();
//        e.submit(new Printer());
//        System.out.println("Hello");
//        e.shutdown();

        List<String> list1 =  new CopyOnWriteArrayList<>();
        list1.add("Melon");
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Mango");

        for (String s : list1) {
            list1.removeIf(str -> str.startsWith("M"));
            System.out.println(s);
        }


        System.out.println(list1);
    }
}
