package com.algo.app.practice.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EarliestMomentBecomeFriendsTest {
    
    private EarliestMomentBecomeFriends e;

    @BeforeEach
    void setup() {
        e = new EarliestMomentBecomeFriends();
    }

    @Test
    void testUsingUF() {
        int n = 4;
        int[][] logs= {
                {0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}
        };

        int actual = e.earliestAcq(logs, n);
        int expected = 3;

        assertEquals(expected, actual);
    }
}
