package com.algo.app.practice.amazon;

import java.util.Arrays;
import java.util.List;

public class AS3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        //rotate(matrix);

        //System.out.println(Arrays.deepToString(matrix));

        System.out.println(groupAnagrams(new String[]{
                "eat","tea","tan","ate","nat","bat"
        }));
    }

    static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {

                System.out.println(matrix[i][j]);
                System.out.println(matrix[j][n - i - 1]);
                System.out.println(matrix[n - 1 - i][n - 1- j]);
                System.out.println(matrix[n - 1 - j][i]);

                System.out.println();
            }
        }
    }

    static void transpose(int[][] matrix) {

    }

    static void reflect(int[][] matrix) {

    }

    static List<List<String>> groupAnagrams(String[] strs) {

        return null;
    }

}
