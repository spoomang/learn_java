package com.algo.app.practice.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberOfConnectedComponentsTest {

    private NumberOfConnectedComponents numberOfConnectedComponents;

    @BeforeEach
    public void setup() {
        numberOfConnectedComponents = new NumberOfConnectedComponents();
    }

    @Test
    public void testUsingUF() {
        int n = 5;
        int[][] edges = {{0, 1}, {1,2}, {3,4}};

        int actualCount = numberOfConnectedComponents.countComponents(n, edges);

        int expectedCount = 2;

        assertEquals(expectedCount, actualCount);

        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1,2},{2,3}, {3,4}};

        int actualCount1 = numberOfConnectedComponents.countComponents(n, edges);

        int expectedCount1 = 1;

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testUsingDFS() {
        int n = 5;
        int[][] edges = {{0, 1}, {1,2}, {3,4}};

        int actualCount = numberOfConnectedComponents.countComponentsDFS(n, edges);

        int expectedCount = 2;

        assertEquals(expectedCount, actualCount);

        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1,2},{2,3}, {3,4}};

        int actualCount1 = numberOfConnectedComponents.countComponents(n, edges);

        int expectedCount1 = 1;

        assertEquals(expectedCount, actualCount);
    }
}
