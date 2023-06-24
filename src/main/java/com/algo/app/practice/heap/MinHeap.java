package com.algo.app.practice.heap;

public class MinHeap {
    int heapSize;
    int realSize;
    int[] heap;

    public MinHeap(int heapSize) {
        heap = new int[heapSize + 1];
        this.heapSize = heapSize;
    }

    public void add(int element) {
        realSize++;

        if(realSize > heapSize) {
            System.out.println("Reached maximum size already");
            return;
        }
        heap[realSize] = element;

        int index = realSize;
        int parent = realSize / 2;

        while(heap[parent] > heap[index] && index > 1) {
            swap(heap, index, parent);
            index = parent;
            parent = parent / 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int pop() {
        if (realSize < 1) {
            System.out.println("Don't have any Element");
            return Integer.MAX_VALUE;
        } else {
            int removeElement = heap[1];
            heap[1] = heap[realSize];
            realSize--;
            heap[realSize + 1] = 0;

            int index = 1;
            while(index <= realSize / 2) {
                int left = 2 * index;
                int right = (2 * index) + 1;

                if (heap[index] > heap[left] || heap[index] > heap[right]) {
                    if (heap[index] > heap[left]) {
                        swap(heap, index, left);
                        index = left;
                    } else {
                        swap(heap, index, right);
                        index = right;
                    }
                } else {
                    break;
                }
            }

            return removeElement;
        }
    }

    public int peek() {
        return heap[1];
    }
}
