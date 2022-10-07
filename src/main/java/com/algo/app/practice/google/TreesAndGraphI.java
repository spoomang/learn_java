package com.algo.app.practice.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TreesAndGraphI {

    public static void main(String[] args) {
        // Redundant connections
        // {1, 2}, {1, 3}, {2, 3}
        int[] result = findRedundantConnection(new int[][]{
                {1, 2}, {1, 3}, {2, 3}
        });
        System.out.println(Arrays.toString(result));
    }


    static int MAX_EDGES = 1000;
    static Set<Integer> seen = new HashSet<>();
    static int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[MAX_EDGES + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge[0], edge[1])) {
                return edge;
            }

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }


        return null;
    }


    static boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) return true;
            for (int neighbour : graph[source]) {
                if (dfs(graph, neighbour, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }


        public boolean union(int x, int y) {
            int xr = find(x);
            int yr = find(y);
            if (xr == yr) {
                return false;
            } else if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
            } else {
                parent[xr] = yr;
                rank[xr]++;
            }

            return true;
        }
    }

    static int[] findRedundantConnectionDSU(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGES + 1);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return null;
    }
}
