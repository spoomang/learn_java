package com.learn.practice.heap.problems;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("ab");
        l.ensureCapacity(3);;

        System.out.println(l.size());

    }
}

class A {
    private A() {
    }

    public A(int a) {

    }
}


class B extends A {

    public B(int b) {
        super(b);
    }
}
