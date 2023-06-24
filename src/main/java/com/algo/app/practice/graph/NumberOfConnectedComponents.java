package com.algo.app.practice.graph;


import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {


    static class UF {
        int[] roots;
        int[] ranks;

        public UF(int n) {
            roots = new int[n];
            ranks = new int[n];

            for (int i = 0; i < n; i++) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        int find(int x) {
            if (x == roots[x]) {
                return x;
            }

            return roots[x] = find(roots[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (ranks[rootX] < ranks[rootY]) {
                    roots[rootX] = rootY;
                } else if (ranks[rootX] >  ranks[rootY]) {
                    roots[rootY] = rootX;
                } else {
                    roots[rootX] = rootY;
                    ranks[rootY] += 1;
                }
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == uf.find(i)) {
                count++;
            }
        }

        return count;
    }

    public int countComponentsDFS(int n, int[][] edges) {
        int count = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                count++;
                dfs(visited, graph, i);
            }
        }

        return count;
    }

    private void dfs(boolean[] visited, List<List<Integer>> graph, int current) {
        if(visited[current]) {
            return;
        }
        visited[current] = true;
        for (int neighbour : graph.get(current)) {
            dfs(visited, graph, neighbour);
        }
    }
}
