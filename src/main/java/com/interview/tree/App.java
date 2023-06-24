package com.interview.tree;

import java.util.Map;

public class App {

    static int max = 0;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    static int maxPathSum(TreeNode root) {
        return max;
    }

    int  dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = node.val + dfs(node.left) + dfs(node.right);

        max = Math.max(max, sum);

        return sum;
    }
}
