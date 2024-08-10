package com.algo.app.leetcode.shortest.path;

import java.util.PriorityQueue;

public class PathWithMinEffort {

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0]- b[0]
        );
        int rows = heights.length;
        int cols = heights[0].length;

        // row, col, effort until now
        pq.add(new int[]{0, 0, 0});

        int[][] movements = {
                {0 , 1}, // right
                {0, -1}, // left
                {1, 0},  // down
                {-1, 0}  // up
        };

        boolean[][] visited = new boolean[rows][cols];

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int row = node[1];
            int col = node[2];
            int minEffortUntilNode = node[0];

            // Check if reached destination
            if (row == rows - 1 && col == cols - 1) {
                return  minEffortUntilNode;
            }
            visited[row][col] = true;

            for (int[] movement : movements) {
                int newRow = row + movement[0];
                int newCol = col + movement[1];
                if (newRow < rows && newCol < cols && newRow >= 0 && newCol >= 0 && !visited[newRow][newCol]) {
                    int effort = Math.max(
                      minEffortUntilNode,
                      Math.abs(heights[row][col] - heights[newRow][newCol])
                    );
                    pq.add(new int[]{effort, newRow, newCol});
                }
            }
        }

        return 0;
    }
}
