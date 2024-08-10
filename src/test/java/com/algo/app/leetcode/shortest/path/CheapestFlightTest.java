package com.algo.app.leetcode.shortest.path;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheapestFlightTest {

    CheapestFlight cheapestFlight = new CheapestFlight();

    @Test
    void testCheapestFlight() {
        int n = 4;
        int[][] flights = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };
        int src = 0;
        int dest = 3;
        int k = 1;

        int expected = 700;

        int actual = cheapestFlight.findCheapestPriceBellmanFord(
                n,
                flights,
                src,
                dest,
                k
        );

        assertEquals(expected, actual);
    }

    @Test
    void testCheapestFlightUsingDjikstra() {
        int n = 4;
        int[][] flights = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };
        int src = 0;
        int dest = 3;
        int k = 1;

        int expected = 700;

        int actual = cheapestFlight.findCheapestPriceDjikstra(
                n,
                flights,
                src,
                dest,
                k
        );

        assertEquals(expected, actual);
    }
}
