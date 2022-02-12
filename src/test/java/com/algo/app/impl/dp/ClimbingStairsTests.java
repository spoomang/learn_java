package com.algo.app.impl.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClimbingStairsTests {

    @BeforeEach
    public void setup() {

    }

    @Test
    public void testNaiveApproach() {
        int expected = 89;
        int actual = ClimbingStairs.climbingStairs(10);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMemoizationBottomUp() {
        int expected = 89;
        int actual = ClimbingStairs.climbingStairsWithMemoization(10);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMemoizationTopBottom() {
        int expected = 89;
        int actual = ClimbingStairs.climbingStairsWithMap(10);

        Assertions.assertEquals(expected, actual);
    }
}
