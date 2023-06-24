package com.learn.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoundedWildCardsDemo {

    public static void main(String[] args) {
       List<Double> d = Arrays.asList(1.4, 4.5, 5.0);
       List<Integer> i = Arrays.asList(1, 4, 5);

        display(d);
        display(i);

        // Not possible as its invariant
        //display1(d);
        //display1(i);

        display2(d);
        display2(i);

        List<Number> aggregate = new ArrayList<>();

        aggregateWithConsumer(d, i, aggregate);

        System.out.printf("aggregateWithConsumer "+aggregate);

        //aggregate(d,i, aggregate);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        go(list);


        int element = list.get(3);
    }

    static <T extends Number> void invarianceWorkAround(List<T> list) {
        Double d = 2.5;

        list.add((T) d);
    }

    static void go(List list) {
        list.add(25.5);
        list.add(35);
    }

    private static<E> void aggregateWithConsumer(List<? extends E> d, List<? extends E> i, List<? super E> aggregate) {
        aggregate.addAll(d);
        aggregate.addAll(i);
    }

    private static<E> void aggregate(List<E> d, List<E> i, List<E> aggregate) {
        aggregate.addAll(d);
        aggregate.addAll(i);
    }

    static void display(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println("display number : "+number);
        }
    }

    static void display1(List<Number> numbers) {
        for (Number number : numbers) {
            System.out.println("display number : "+number);
        }
    }

    static<T extends Number> void display2(List<T> numbers) {
        for (Number number : numbers) {
            System.out.println("display number : "+number);
        }
    }

    static int getCommonElementCount(List<?> list1, List<?> list2){
        int count = 0;

        return count;
    }

    static <T, U> U temp(T t, U u) {

        return u;
    }

}
