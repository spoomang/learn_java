package com.algo.app.practice.uniquePath;


public class UniquePath3 {

    int pathCount;
    int row;
    int col;
    int[][] grid;

    public static void main(String[] args) {

    }

    public int uniquePathIII(int[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;

        int remaining = 0;
        int start_row = 0;
        int start_col = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] >= 0) {
                    remaining++;
                }

                if (grid[i][j] == 1) {
                    start_row = i;
                    start_col = j;
                }
            }
        }

        backtrack(start_row, start_col, remaining);

        return pathCount;
    }

    void backtrack(int r, int c, int remaining) {
        if (grid[r][c] == 2 && remaining == 1) {
            pathCount += 1;
            return;
        }

        int temp = grid[r][c];
        grid[r][c] = -4;
        remaining -= 1;

        int[] rowOffset = {0, 0, 1, -1};
        int[] colOffset = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int new_row = r + rowOffset[i];
            int new_col = c + colOffset[i];

            if (new_row < 0 || new_row >= row || new_col < 0 || new_col >= col || grid[new_row][new_col] < 0) {
                continue;
            }
            backtrack(new_row, new_col, remaining);
        }


        grid[r][c] = temp;
    }
}
