package com.learn.practice.heap.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,9},
                {10,11,13},
                {12,13,15}};
        int k = 8;

        System.out.println(kthLargest(matrix, k));
        System.out.println(kthLargestUsingBinarySearch(matrix, k));
    }

    static class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    static  class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.val - o2.val;
        }
    }

    static int kthLargest(int[][] matrix, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>(k, new MyComparator());
        int n = matrix.length;

        for (int i = 0; i < Math.min(k, n); i++) {
            queue.offer(new Node(i, 0, matrix[i][0]));
        }

        Node element = queue.peek();
        while (k-- > 0) {
            element = queue.poll();
            int r = element.row;
            int c = element.col;

            if (c < n - 1) {
                queue.offer(new Node(r, c + 1, matrix[r][c+1]));
            }
        }

        return element.val;
    }

    static int kthLargestUsingBinarySearch(int[][] matrix, int k) {

        return 0;
    }
}
