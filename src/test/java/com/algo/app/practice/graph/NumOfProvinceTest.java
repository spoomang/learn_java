package com.algo.app.practice.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumOfProvinceTest {

    NumOfProvince numOfProvince = new NumOfProvince();

    @Test
    public void testNumOfProvinceDFS() {
        int [][] q1 = {
                {1,1,0},{1,1,0},{0,0,1}
        };
        int [][] q2 = {
                {1,0,0},{0,1,0},{0,0,1}
        };

        int expectedQ1 = 2;
        int expectedQ2 = 3;

        int actualQ1 = numOfProvince.findCircleNumDFS(q1);
        int actualQ2 = numOfProvince.findCircleNumDFS(q2);

        assertEquals(expectedQ1, actualQ1);
        assertEquals(expectedQ2, actualQ2);
    }

    @Test
    public void testNumOfProvinceBFS() {
        int [][] q1 = {
                {1,1,0},{1,1,0},{0,0,1}
        };
        int [][] q2 = {
                {1,0,0},{0,1,0},{0,0,1}
        };

        int expectedQ1 = 2;
        int expectedQ2 = 3;

        int actualQ1 = numOfProvince.findCircleNumBFS(q1);
        int actualQ2 = numOfProvince.findCircleNumBFS(q2);

        assertEquals(expectedQ1, actualQ1);
        assertEquals(expectedQ2, actualQ2);
    }

    @Test
    public void testNumOfProvinceUF() {
        int [][] q1 = {
                {1,1,0},{1,1,0},{0,0,1}
        };
        int [][] q2 = {
                {1,0,0},{0,1,0},{0,0,1}
        };

        int expectedQ1 = 2;
        int expectedQ2 = 3;

        int actualQ1 = numOfProvince.findCircleNumUF(q1);
        int actualQ2 = numOfProvince.findCircleNumUF(q2);

        assertEquals(expectedQ1, actualQ1);
        assertEquals(expectedQ2, actualQ2);
    }
}
