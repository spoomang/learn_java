package com.algo.app.practice.google;

public class TreesAndGraphII {

    public static void main(String[] args) {

    }

    static class UnionFind {
        int count; // num of connected components
        int[] parent;
        int[] rank;

        public UnionFind(int[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                }
                
            }
        }

        int find (int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = parent[y];
                } else {
                    parent[rootx] = rooty;
                    parent[rootx]++;
                }
                count--;
            }
        }
    }

}
