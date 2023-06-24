package com.algo.app.practice.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {
    static List<List<Integer>> output = new ArrayList<>();
    static int n;
    static int k;

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        combinations(n, k);

        System.out.println(output);
    }

    static List<List<Integer>> combinations(int n1, int k1) {
        n = n1;
        k = k1;

        backtrack(1, new LinkedList<>());

        return output;
    }

    static void backtrack(int first, LinkedList<Integer> integers) {

        if (integers.size() == k) {
            output.add(new LinkedList<>(integers));
            return;
        }

        for (int j = first; j < n + 1; j++) {
            integers.add(j);
            backtrack(j + 1, integers);
            integers.removeLast();
        }
    }

}
