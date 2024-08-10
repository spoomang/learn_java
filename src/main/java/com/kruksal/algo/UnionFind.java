package com.kruksal.algo;

public class UnionFind {
    int[] rank;
    int[] group;

    public UnionFind(int n) {
        rank = new int[n];
        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    public int find(int node) {
        if (group[node] != node) {
            group[node] = find(group[node]);
        }
        return group[node];
    }

    public boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if (parent2 == parent1) {
            return false;
        }

        if (rank[parent1] > rank[parent2]) {
            group[parent2] = parent1;
        } else if (rank[parent1] < rank[parent2]) {
            group[parent1] = parent2;
        } else {
            group[parent1] = parent2;
            rank[parent2] += 1;
        }

        return true;
    }
}
