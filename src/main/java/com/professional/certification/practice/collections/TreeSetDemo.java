package com.professional.certification.practice.collections;

import java.util.Arrays;
import java.util.List;

public class TreeSetDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "a", "b");
        System.out.println(list.stream().noneMatch(s -> s.equals("x")));
    }
}
