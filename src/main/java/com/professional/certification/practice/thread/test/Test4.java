package com.professional.certification.practice.thread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

class CustomRecursiveAction extends RecursiveAction {
    private String workload;
    private static int THRESHOLD = 4;

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length()  > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubTasks());
        } else {
            processing(workload);
        }
    }

    private List<CustomRecursiveAction> createSubTasks() {
        List<CustomRecursiveAction> subTasks = new ArrayList<>();

        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());

        subTasks.add(new CustomRecursiveAction(partOne));
        subTasks.add(new CustomRecursiveAction(partTwo));

        return subTasks;
    }

    private void processing(String workload) {
        String result = workload.toUpperCase();
        System.out.println("The result ("+result+") was processed by "
                + Thread.currentThread().getName());
    }
}

class Adder extends RecursiveAction {
    private int from;
    private int to;
    static int total = 0;

    public Adder(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected void compute() {
        if (to - from <= 4) {
            int sum = 0;
            for (int i = from; i <= to; i++) {
                sum += i;
            }

            total += sum;
        } else {
            int mid = (from + to) / 2;
            Adder first = new Adder(from , mid);
            Adder second = new Adder(mid + 1, to);

            invokeAll(first, second);
        }
    }
}

public class Test4 {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        Adder adder = new Adder(1, 6);

        forkJoinPool.invoke(adder);

        System.out.println(adder.total);

    }
}
