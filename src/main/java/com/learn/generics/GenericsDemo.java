package com.learn.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericsDemo {

    public static void main(String[] args) {

        // cannot resolve due to invariance property
        // go(new ArrayList<Integer>());

        // Covariance property, it is possible but will throw ArrayStoreException
        go(new Integer[1]);
        go("Dasd");
    }

    static void genericMethodsDemo() {
        typeArgInference(22.0);
        typeArgInference("Java");

        // Compile-time type-safety benefit in a generic method
        // Double s = typeArgInference1("Java");
        Double d = typeArgInference1(22.0);


        Integer[] na = new Integer[100];
        Collection<Integer> cs = new ArrayList<>();
        // Collection<Number> cs = new ArrayList<>(); // This will work
        // Collection<String> cs = new ArrayList<>(); // This will not work

        arrayToCollection(na, cs);

        String s = typeArgInferenceFromTargetType1();
        Double d1 = typeArgInferenceFromTargetType1();
    }

    static <T> T typeArgInferenceFromTargetType1() {
        return (T) "abc";
    }

    static<T> void arrayToCollection(T[] n, Collection<T> c) {
        for (T o : n) {
            c.add(o);
        }
    }

    static <T> void typeArgInference(T t) {
        System.out.println("Class name"+t.getClass().getName());
    }

    static <T> T typeArgInference1(T t) {
        System.out.println("Class name"+t.getClass().getName());
        return t;
    }

    // Invariance
    static <T> void go (T t) {
        System.out.println("asdas"+t);
    }

//    static void go(Number[] l) {
//        l[0] = 24.4;
//    }

    static <T, U, V> T m(T t, U u, V v) {
        return t;
    }
}
interface Container<String> {
    String get();
    void set(String t);
}

class Store<T> implements Container<T> {

    @Override
    public T get() {
        return null;
    }

    @Override
    public void set(T t) {

    }
}
