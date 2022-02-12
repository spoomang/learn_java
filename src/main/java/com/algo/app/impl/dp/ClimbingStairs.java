package com.algo.app.impl.dp;

import java.util.HashMap;

public class ClimbingStairs {

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static int climbingStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return climbingStairs(n - 1 ) + climbingStairs(n - 2);
    }

    public static int climbingStairsWithMemoization(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static int climbingStairsWithMap(int n) {
        if (n <=  2) {
            return n;
        }

        if (!map.containsKey(n)) {
            map.put(n, climbingStairsWithMap(n - 1) + climbingStairsWithMap(n - 2));
        }

        return map.get(n);
    }
}
