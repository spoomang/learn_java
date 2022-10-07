package com.algo.app.practice;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        int[] costs = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCost(costs));
        System.out.println(topToBottomApproach(costs));
    }

    static int minCost(int[] costs) {
        int[] dp = new int[costs.length + 1];

        for (int i = 2; i <= costs.length ; i++) {

            dp[i] = Math.min(dp[i - 1] + costs[i - 1], dp[i - 2] + costs[i - 2]);

        }

        return dp[costs.length];
    }

    static int topToBottomApproach(int[] costs) {

        return recurse(costs, costs.length);
    }

    static Map<Integer, Integer> memo = new HashMap<>();

    static int recurse(int[] costs, int i) {
        if (i < 2) {
            return 0;
        }

        if (memo.get(i) != null) {
            return memo.get(i);
        }

        int minCost = Math.min(recurse(costs, i - 1) + costs[i - 1], recurse(costs, i - 2) + costs[i - 2]);

        memo.put(i, minCost);

        return minCost;
    }
}
