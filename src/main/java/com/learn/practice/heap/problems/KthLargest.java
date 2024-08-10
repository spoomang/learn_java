package com.learn.practice.heap.problems;

import java.util.*;

public class KthLargest {
    static int findKthLargest(int[] nums, int k) {
// Method 1.
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//
//        for (int n : nums) {
//            q.add(n);
//            if(q.size() > k) {
//                q.poll();
//            }
//        }
//
//        return q.peek();

        List<Integer> list = new ArrayList<>();

        for (int n : nums) {
            list.add(n);
        }

        return quickSelect(list, k);
    }

    static int quickSelect(List<Integer> list, int k) {
        int pivotIndex = new Random().nextInt(list.size());
        int pivot = list.get(pivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int n : list) {
            if (n > pivot) {
                left.add(n);
            } else if (n < pivot) {
                right.add(n);
            } else {
                mid.add(n);
            }
        }

        if (left.size() >= k) {
            return quickSelect(left, k);
        }

        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size()  - right.size());
        }

        return pivot;
    }

    class Pair {
        int key;
        int count;

        public Pair(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int p = map.getOrDefault(n, 0);
            p += 1;
            map.put(n, p);
        }


        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });


        for (int n : map.keySet()) {
            q.add(n);
            if (q.size() > k) {
                q.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int p = q.poll();
            result[i] = p;
        }

        return result;
    }

    public static void main(String[] args) {
        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}
