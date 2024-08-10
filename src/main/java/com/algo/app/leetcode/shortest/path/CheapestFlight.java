package com.algo.app.leetcode.shortest.path;

import java.util.*;

public class CheapestFlight {

    public int findCheapestPriceBellmanFord(int n, int[][] flights, int src, int dst, int k) {
        int[] minPrices = new int[n];
        Arrays.fill(minPrices, Integer.MAX_VALUE);
        minPrices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(minPrices, n);
            for (int[] flight : flights) {
                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];

                if(minPrices[source] != Integer.MAX_VALUE) {
                    temp[destination] = Math.min(
                            temp[destination],
                            minPrices[source] + price
                            );
                }
            }
            minPrices = temp;
        }

        return minPrices[dst];
    }

    public int findCheapestPriceDjikstra(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight: flights) {
            adj.putIfAbsent(flight[0], new ArrayList<>());
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        // price, node, steps
        pq.add(new int[]{0, src, 0});
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[src] = 0;

        while (!pq.isEmpty()) {
            int[] entry = pq.poll();
            int price = entry[0];
            int node = entry[1];
            int step = entry[2];

            if (step > steps[node] || step > k + 1)
                continue;
            if (node == dst) {
                return price;
            }
            if (!adj.containsKey(node)) {
                continue;
            }

            steps[node] = step;
            for (int[] neighbour : adj.get(node)) {
                int destination = neighbour[0];
                int priceFromNode = neighbour[1];

                pq.add(new int[]{price + priceFromNode, destination, step + 1});
            }
        }


        return 0;
    }
}
