package com.algo.app.practice.graph;

import java.util.*;

public class ValidTree {

    public boolean validTreeDFS(int n, int[][] edges) {
        if (edges.length != n - 1 ) {
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        boolean result = dfs(graph, visited, 0, -1);

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return result;
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int node, int parent) {
        if (visited[node]) {
            return false;
        }

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                if (!dfs(graph, visited, neighbor, node)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean validTreeDFSIterative(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbor : graph.get(node)) {
                if (visited[neighbor]) {
                    continue;
                }

                visited[neighbor] = true;
                stack.add(neighbor);
            }
        }

        for(boolean v : visited){
            if (!v) {
                return false;
            }
        }

        return true;
    }


    public boolean validTreeBFS(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for(int neighbor : graph.get(node)) {
                if (visited[neighbor]) {
                    continue;
                }

                visited[neighbor] = true;
                q.add(neighbor);
            }
        }

        for(boolean v : visited){
            if (!v) {
                return false;
            }
        }

        return true;
    }


    static class UF {
        int[] roots;

        public UF(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
        }

        int find(int i) {
            if (roots[i] == i) {
                return i;
            }

            return roots[i] = find(roots[i]);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootY != rootX) {
                roots[rootX] = rootY;
                return true;
            }

            return false;
        }

    }

    public boolean validTreeUF(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }

        UF uf = new UF(n);

        for (int[] edge :edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }
}
