package com.algo.app.practice.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {

        int[] arr= {1, 2, 3, 4, 5, 7, 8, 9};

        System.out.println(Arrays.toString(arr));
        heapSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i >= 0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr, i, 0);
        }
    }

    static void maxHeapify(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            maxHeapify(arr, heapSize, largest);
        }
    }

    static void heapSort1(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            minHeapify(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i >= 0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            minHeapify(arr, i, 0);
        }
    }

    static void minHeapify(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        if (left < heapSize && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < heapSize && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            int temp = arr[smallest];
            arr[smallest] = arr[index];
            arr[index] = temp;
            maxHeapify(arr, heapSize, smallest);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(
                (a, b) -> a < b ? 1 : -1
        );

        for(int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        int kLargest = 0;

        for (int i = 0; i < k; i++) {
            kLargest = q.poll();
        }

        return kLargest;
    }
}
