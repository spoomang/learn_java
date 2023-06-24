package com.algo.app.practice.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateImage {

    public static void main(String[] args) {
        List<String> a = Arrays.asList("a", "b", "c");
        List<String> c = Arrays.asList("e", "f", "g");
        List<String> b = new ArrayList<>();

        b.addAll(a);
        b.addAll(c);

        System.out.println(b);
    }

    public void rotate(int[][] input) {
        int n = input.length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = input[i][j];
                input[i][j] = input[n - 1 - j][i];
                input[n - 1 - j][i] = input[n - 1 - i][n - 1 - j];
                input[n - 1 - i][n - 1 - j] = input[j][n - 1 - i];
                input[j][n - 1 - i] = temp;
            }
        }
    }

    public void rotate1(int[][] input) {
        transpose(input);
        reflect(input);
    }

    public void transpose(int[][] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = temp;
            }
        }
    }

    public void reflect(int[][] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = input[i][n - 1 - j];
                input[i][n - 1 - j] = input[i][j];
                input[i][j] = temp;
            }
        }
    }
}
