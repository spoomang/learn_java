package com.algo.app.practice.uniquePath;

public class UniquePath2 {
    int[][] grid;
    int row;
    int col;
    int paths;

    public static void main(String[] args) {

    }

    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        if (grid[0][0] == 1) {
            return 0;
        }

        grid[0][0] = 1;

        for (int i = 1; i < R; i++) {
            grid[i][0] = grid[i - 1][0] == 1 && grid[i][0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < C; i++) {
            grid[0][i] = grid[0][i - 1] == 1 && grid[0][i] == 0 ? 1 : 0;
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] =  grid[i - 1][j] + grid[i][j -1];
                } else {
                    grid[i][j] =  0;
                }
            }
        }
        

        return obstacleGrid[R - 1][C - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid;
        row = grid.length;
        col = grid[0].length;

        backtrack(0, 0);

        return paths;
    }

    void backtrack(int r, int c) {
        if (r == row - 1 && c == col - 1) {
            paths++;
            return;
        }

        int temp = grid[r][c];
        grid[r][c] = 2;
        int[] rowOffset = {0, 1};
        int[] colOffset = {1, 0};

        for (int i = 0; i < 2; i++) {
            int new_row = r + rowOffset[i];
            int new_col = c + colOffset[i];

            if (new_row < 0 || new_row >= row || new_col < 0 || new_col >= col || grid[new_row][new_col] > 0) {
                continue;
            }

            backtrack(new_row, new_col);
        }

        grid[r][c] = temp;
    }
}
