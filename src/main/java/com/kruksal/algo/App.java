package com.kruksal.algo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {

    }

    static int minCostConnectionPointsPrims(int[][] points) {
        int minCost = 0;
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));

        q.add(new Pair<>(0, 0));
        int numOfEdges = 0;
        int n = points.length;
        boolean[] inMst = new boolean[n];

        while (numOfEdges < n) {
            Pair<Integer, Integer> node = q.poll();
            
            int w = node.getKey();
            int i = node.getValue();

            if (inMst[i]) {
                continue;
            }

            inMst[i] = true;
            minCost += w;
            numOfEdges++;

            for (int j = 0; j < n; j++) {
                if (!inMst[j]) {
                    int weight = Math.abs(points[i][0] - points[j][0])
                            + Math.abs(points[i][1] - points[j][1]);
                    q.add(new Pair<>(weight, j));
                }
            }
        }

        return minCost;
    }

    static int minCostConnectionPointsPrimsWithoutQueue(int[][] points) {
        int cost = 0;
        int n = points.length;
        boolean[] inMst = new boolean[n];
        int[] minDist = new int[n];

        minDist[0] = 0;
        for (int i = 1; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        int edgesUsed = 0;

        while (edgesUsed < n) {
            int currentWeight = Integer.MAX_VALUE;
            int currNode = -1;

            for (int i = 0; i < n; i++) {
                if (!inMst[i] && minDist[i] < currentWeight) {
                    currentWeight = minDist[i];
                    currNode = i;
                }
            }

            cost += currentWeight;
            edgesUsed++;
            inMst[currNode] = true;

            for (int i = 0; i < n; i++) {
                if(!inMst[i]) {
                    int w = Math.abs(points[currNode][0]- points[i][0])
                            + Math.abs(points[currNode][1]- points[i][1]);
                    minDist[i] = w;
                }
            }
        }



        return cost;
    }

    static int minCostConnectionPointsKruksalAlgo(int[][] points) {
        int minCost = 0;
        int n = points.length;
        ArrayList<int[]> allEdges = new ArrayList<>();

        for (int currNode = 0; currNode < n; currNode++) {
            for (int nextNode = currNode  + 1; nextNode < n; nextNode++) {
                int weight =
                        Math.abs(points[currNode][0] - points[nextNode][0])
                        + Math.abs(points[currNode][1] - points[nextNode][1]);

                allEdges.add(new int[]{weight, currNode, nextNode});
            }
        }

        Collections.sort(allEdges, (node1, node2) -> Integer.compare(node1[0], node2[0]));


        UnionFind uf = new UnionFind(n);
        int edgesUsed = 0;

        for (int i = 0; i < allEdges.size() && edgesUsed < n-1;i++) {
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            int weight = allEdges.get(i)[0];

            if (uf.union(node1, node2)) {
                minCost += weight;
                edgesUsed++;
            }
        }

        return minCost;
    }
}
