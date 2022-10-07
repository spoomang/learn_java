package com.learn.generics;

import java.util.HashMap;
import java.util.HashSet;

public class GenericsDemo {

    public static void main(String[] args) {
        Container<String> s = new Store();
        s.set("bupp!");
        System.out.println(s.get());


        Container<Integer> i = new Store();
        i.set(23);
        System.out.println(i.get());

    }
}

interface Container<String> {
    String get();
    void set(String t);
}

class Store<String> implements Container<String> {
    String  t;

    public String get() {
        return t;
    }

    @Override
    public void set(String t) {
        this.t = t;
    }
}
