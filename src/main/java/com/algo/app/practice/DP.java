package com.algo.app.practice;

public class DP {
    public static void main(String[] args) {
        houseRobberII(new int[] {2,3,2});
    }

    static void houseRobber(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i -1]);
        }


        System.out.println("Answer is : "+dp[nums.length]);
    }


    // Houses are in circle first and last house cannot be robbed
    static void houseRobberII(int[] numbers) {

    }

    static int robSimple(int[] numbers, int start, int end) {
        int t1=0, t2=0;

        for (int i = start; i <= end; i++) {
            int temp = t1;
            t1 = Math.max(numbers[i] + t2, t1);
            t2 = temp;
        }

        return t1;
    }
}
