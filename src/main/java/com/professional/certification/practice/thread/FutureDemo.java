package com.professional.certification.practice.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    public static void main(String[] args) throws InterruptedException {
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);

                return "HELLO";
            }
        };

        ExecutorService s = Executors.newFixedThreadPool(1);
        List<Callable<String>> list = Arrays.asList(c, c, c, c, c);
        System.out.println("STart");
        List<Future<String>> futures = s.invokeAll(list);
        System.out.println(futures.size());
        s.shutdown();
    }
}
