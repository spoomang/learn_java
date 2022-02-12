package com.algo.app.impl.dp;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        System.out.println("Climbing stairs : "+ ClimbingStairs.climbingStairs(10));
        System.out.println("Climbing stairs with memoization bottom up: "+ ClimbingStairs.climbingStairsWithMemoization(10));
        System.out.println("Climbing stairs with map top down : "+ ClimbingStairs.climbingStairsWithMap(10));
    }

}
