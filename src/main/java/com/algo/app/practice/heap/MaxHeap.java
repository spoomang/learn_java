package com.algo.app.practice.heap;

public class MaxHeap {
    int heapSize;
    int realSize;
    int[] heap;

    public MaxHeap(int heapSize) {
        this.heapSize = heapSize;
        this.heap = new int[heapSize + 1];
    }

    public void add(int element) {
        if (realSize > heapSize) {
            System.out.println("Heap is full.");
            return;
        } else {
            realSize++;
            heap[realSize] = element;

            int index = realSize;
            int parent  = realSize / 2;

            while (heap[parent] < heap[index] && index > 1) {
                swap(parent, index);
                index = parent;
                parent = parent / 2;
            }
        }
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int peek() {
        return heap[1];
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

                if (heap[index] < heap[left] || heap[index] < heap[right]) {
                    if (heap[index] > heap[left]) {
                        swap(index, left);
                        index = left;
                    } else {
                        swap(index, right);
                        index = right;
                    }
                } else {
                    break;
                }
            }

            return removeElement;
        }
    }
}
