package com.algo.app.practice.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {

    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int c = map.getOrDefault(n, 0);
            map.put(n, c + 1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(
                (a,b) -> map.getOrDefault(a, 0) > map.getOrDefault(b, 0) ? -1 : 1
        );

        int[] result = new int[k];

        for (int n: nums) {
            if (!q.contains(n)) {
                q.add(n);
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = q.poll();
        }


        return result;
    }
}
