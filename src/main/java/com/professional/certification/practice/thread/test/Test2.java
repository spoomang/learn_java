package com.professional.certification.practice.thread.test;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Caller implements Callable<Void> {
    String str;

    public Caller(String str) {
        this.str = str;
    }

    @Override
    public Void call() {
        System.out.println(str.toUpperCase());
        return null;
    }
}

class MyCallable implements Callable<Integer> {
    private Integer i;

    public MyCallable(Integer i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        return --i;
    }
}

class MyThread extends Thread {
    private int i;

    public MyThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        i++;
    }
}

public class Test2 {
    public static void main(String[] args) throws Exception{
        ExecutorService e = Executors.newSingleThreadExecutor();
        MyCallable c = new MyCallable(10);
        MyThread m = new MyThread(10);
        System.out.println(e.submit(c).get());
        System.out.println(e.submit(m).get());
        e.shutdown();
    }
}
