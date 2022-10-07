package com.algo.app.practice.google;

import javafx.util.Pair;

import java.util.*;
import java.util.LinkedList;

public class TreesAndGraph {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
  }

    public static void main(String[] args) {
//        System.out.println(ladderLength(
//                "hit",
//                "cog",
//                Arrays.asList("hot","dot","dog","lot","log","cog")
//        ));


    }

    static int maxPathSum;

    static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSum;
    }

    static int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_gain = maxGain(root.left);
        int right_gain = maxGain(root.right);

        maxPathSum = Math.max(maxPathSum, left_gain + right_gain + root.val);


        return Math.max(root.val + left_gain, root.val + right_gain);
    }

    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> allCombinations = new HashMap<>();

        int L = beginWord.length();

        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String combination = word.substring(0, i)+"*"+word.substring(i + 1, L);
                List<String> words = allCombinations.getOrDefault(combination, new ArrayList<>());
                words.add(word);
                allCombinations.put(combination, words);
             }
        });


        Pair<String, Integer> pair = new Pair<>(beginWord, 1);
        Queue<Pair<String, Integer>> Q = new LinkedList<>();

        Q.add(pair);

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.poll();
            String w = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i++) {
                String combination = w.substring(0, i)+"*"+w.substring(i + 1, L);
                List<String> list = allCombinations.getOrDefault(combination, new ArrayList<>());

                for (String word : list) {
                    if (word.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.containsKey(word)) {
                        visited.put(word, true);
                       Q.add(new Pair<>(word, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    static int numIslands(char[][] grid) {
        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numOfIslands;
    }

    static void dfs(char[][] grid, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;

        if (r >= n || r < 0 || c >= m || c <0 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    static int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numOfIslands = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    grid[i][j] = '0';

                    Queue<Integer> Q = new LinkedList<>();
                    Q.add(i * nc + j);
                    while (!Q.isEmpty()) {
                        int id = Q.remove();

                        int row  = id / nc;
                        int col = id % nc;

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '0';
                            Q.add((row - 1) * nc + col);
                        }

                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '0';
                            Q.add((row + 1) * nc + col);
                        }

                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '0';
                            Q.add(row * nc + (col + 1));
                        }

                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '0';
                            Q.add(row * nc + (col - 1));
                        }
                    }
                }
            }
        }

        return numOfIslands;
    }
}
