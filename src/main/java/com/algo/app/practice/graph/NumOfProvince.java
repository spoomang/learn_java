package com.algo.app.practice.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class NumOfProvince {

    public int findCircleNumDFS(int[][] M) {
        int count = 0;
        int N = M.length;
        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(M, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNumBFS(int[][] M) {
        int count = 0;
        int n = M.length;
        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                q.add(i);

                while (!q.isEmpty()) {
                    int city = q.poll();
                    visited[city] = 1;

                    for (int j = 0; j < n; j++) {
                        if (visited[j] == 0 && M[i][j] == 1) {
                            q.add(j);
                        }
                    }
                }
                count++;
            }
        }

        return count;
    }

    public int findCircleNumUF(int[][] M) {
        int count = 0;
        int n = M.length;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        
        return count;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);

        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }

}
