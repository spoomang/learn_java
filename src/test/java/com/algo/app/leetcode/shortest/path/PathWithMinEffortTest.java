package com.algo.app.leetcode.shortest.path;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathWithMinEffortTest {

    PathWithMinEffort pathWithMinEffort = new PathWithMinEffort();

    @Test
    void testMinEffort() {
        int[][] height = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };

        int actual = pathWithMinEffort.minimumEffortPath(
                height
        );
        int expected = 2;

        assertEquals(expected, actual);
    }
}
