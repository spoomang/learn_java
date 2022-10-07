package com.algo.app.practice;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {3,5,1,2,9,7,8};
        //partition(arr, 0, arr.length - 1);
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    static void partition(int [] arr, int left, int right) {
        if(left > right) {
            return;
        }

        int pivot = pivot(arr, left, right);

        partition(arr, left , pivot - 1);
        partition(arr, pivot + 1 , right);
    }

    static int pivot(int[] arr, int left, int right) {
        int pivot = arr[right];

        int j = left;
        for (int i = left; i < right ; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, j, right);

        return j;
    }

    static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
            }
        }
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
