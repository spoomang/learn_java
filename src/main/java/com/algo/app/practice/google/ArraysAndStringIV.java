package com.algo.app.practice.google;

public class ArraysAndStringIV {

    static enum Index {
        GOOD, BAD, UNKNOWN
    }

    static Index[] memo;

    public static void main(String[] args) {

        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump1(new int[]{3,2,1,0,4}));
    }

    static boolean canJump(int[] arr) {
        return canJumpFromPosition(0, arr);
    }



    static boolean canJumpFromPosition(int position, int[] arr) {
        if (arr.length - 1 == position) {
            return true;
        }

        int furthest = Math.min(position + arr[position], arr.length - 1);
        for (int i = position + 1; i <= furthest ; i++) {
            System.out.println("position... "+i);
            if (canJumpFromPosition(i, arr)) {
                System.out.println("once... "+i);
                return true;
            }
        }
        return false;
    }

    static boolean canJump1(int[] arr) {
        memo = new Index[arr.length];
        for (int i = 0; i < arr.length; i++) {
            memo[i] = Index.UNKNOWN;

        }

        memo[arr.length - 1] = Index.GOOD;
        return canJumpFromPosition1(0, arr);
    }

    static boolean canJumpFromPosition1(int position, int[] arr) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }

        int furthest = Math.min(position + arr[position], arr.length - 1);
        for (int i = position + 1; i <= furthest; i++) {
            System.out.println("position... #"+i);
            if(canJumpFromPosition1(i, arr)) {
                System.out.println("once... #"+i);
                memo[i] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;

        return false;
    }

    static boolean canJumpWithoutRecursion(int[] nums) {
       Index[] memo1 = new Index[nums.length];

        for (int i = 0; i < memo.length ; i++) {
            memo1[i] = Index.UNKNOWN;
        }

        memo1[nums.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0 ; i--) {
            int farthest = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j < farthest; j++) {
                if (memo1[j] == Index.GOOD) {
                    memo1[i] = Index.GOOD;
                    break;
                }

            }

        }


       return memo1[0] == Index.GOOD;
    }

    static boolean canJumpGreedy(int[] arr) {
        // 4,3,2,1
        int lastPosition = arr.length - 1;



        return lastPosition == 0;
    }
}
