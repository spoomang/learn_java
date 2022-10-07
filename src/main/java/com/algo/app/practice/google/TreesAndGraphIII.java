package com.algo.app.practice.google;

import java.util.*;

public class TreesAndGraphIII {

    public static void main(String[] args) {

        int[]order = findOrderInDegree(4, new int[][]{
                {1,0},{2,0},{3,1},{3,2}
        });

        System.out.println(Arrays.toString(order));
    }

    static int WHITE = 0;
    static int GRAY = 1;
    static int BLACK = 2;

    static boolean isPossible;
    static Map<Integer, Integer> color;
    static Map<Integer, List<Integer>> adjacencyList;

    static List<Integer> topologicalOrder;

    static void  init(int numCourses) {
        isPossible = true;
        color = new HashMap<>();
        adjacencyList = new HashMap<>();
        topologicalOrder = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }
    }

    static int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses);

        for (int[] edge: prerequisites) {
            int src = edge[1];
            int dest = edge[0];
            List<Integer> list = adjacencyList.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            adjacencyList.put(src, list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }

        int[] order;
        if (isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = topologicalOrder.get(numCourses - 1 - i);
            }
        } else {
            order = new int[0];
        }

        return order;
    }

    static void dfs(int node) {
        if (!isPossible) {
            return;
        }

        color.put(node, GRAY);

        for (int neighbour : adjacencyList.getOrDefault(node, new ArrayList<>())) {
            if (color.get(neighbour) == WHITE) {
                dfs(neighbour);
            } else if (color.get(neighbour) == GRAY) {
                isPossible = false;
            }
        }

        color.put(node, BLACK);
        topologicalOrder.add(node);
    }

    static int[] findOrderInDegree(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int [] order = new int[numCourses];

        return null;
    }
}
