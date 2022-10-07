package com.algo.app.practice.google;

import java.util.Arrays;

public class DynamicProgrammingII {

    public static void main(String[] args) {
        int ans = coinChangeBottomUp(new int[]{1,2,5}, 11);
        System.out.println(ans);
    }


    static int coinChangeBottomUp(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < amount; i++) {
            for (int coin : coins) {

            }
        }

        return 0;
    }
}
