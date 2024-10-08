package com.algo.app.practice.algo.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RotateImageTest {

    RotateImage r;

    @BeforeEach
    public void setup() {
        r = new RotateImage();
    }

    @Test
    public void test(){
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        r.rotate1(input);

        System.out.println(Arrays.deepToString(input));

        assertArrayEquals(expected, input);

    }

    @Test
    public void test1(){
        int[][] input = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        int[][] expected = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };

        r.rotate1(input);

        System.out.println(Arrays.deepToString(input));

        assertArrayEquals(expected, input);
    }
}
