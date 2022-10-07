package com.professional.certification.practice.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    static class Printer implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Done");
            return null;
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(new Printer());
        System.out.println("Hello");
        service.shutdown();
    }
}
