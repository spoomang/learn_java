package com.algo.app.practice.graph;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class ValidTreeTest {

    ValidTree vt = new ValidTree();

    @Test
    public void testDFS() {
        int n = 5;
        int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}};
        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3}, {1, 4}};
        int[][] edges3 = {{2,3}, {1, 2}, {1, 3}};

        boolean actualValue1 = vt.validTreeDFS(n, edges1);
        boolean actualValue2 = vt.validTreeDFS(n, edges2);
        boolean actualValue3 = vt.validTreeDFS(4, edges3);

        assertTrue(actualValue1);
        assertFalse(actualValue2);
        assertFalse(actualValue3);
    }

    @Test
    public void testDFSIterative() {
        int n = 5;
        int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}};
        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3}, {1, 4}};
        int[][] edges3 = {{2,3}, {1, 2}, {1, 3}};

        boolean actualValue1 = vt.validTreeDFSIterative(n, edges1);
        boolean actualValue2 = vt.validTreeDFSIterative(n, edges2);
        boolean actualValue3 = vt.validTreeDFSIterative(4, edges3);

        assertTrue(actualValue1);
        assertFalse(actualValue2);
        assertFalse(actualValue3);
    }

    @Test
    public void testBFS() {
        int n = 5;
        int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}};
        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3}, {1, 4}};
        int[][] edges3 = {{2,3}, {1, 2}, {1, 3}};

        boolean actualValue1 = vt.validTreeBFS(n, edges1);
        boolean actualValue2 = vt.validTreeBFS(n, edges2);
        boolean actualValue3 = vt.validTreeBFS(4, edges3);

        assertTrue(actualValue1);
        assertFalse(actualValue2);
        assertFalse(actualValue3);
    }

    @Test
    public void testUF() {
        int n = 5;
        int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}};
        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3}, {1, 4}};
        int[][] edges3 = {{2,3}, {1, 2}, {1, 3}};

        boolean actualValue1 = vt.validTreeUF(n, edges1);
        boolean actualValue2 = vt.validTreeUF(n, edges2);
        boolean actualValue3 = vt.validTreeUF(4, edges3);

        assertTrue(actualValue1);
        assertFalse(actualValue2);
        assertFalse(actualValue3);
    }
}
