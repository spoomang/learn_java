package com.assus.interview;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println(max(new int[]{-1, 10000}));
    }


    static int max(int[] arr) {
        int result = 0;
        Arrays.sort(arr);

        if (arr[arr.length -1] < 0) {
            return arr[0];
        }

        int start = 0;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] < 0 ) {
                start = i + 1;
            }
       }

        int j = 1;
        for (int i = start; i < arr.length; i++) {
            result += arr[i] * j++;
        }

        return result;
    }
}
