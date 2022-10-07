package com.algo.app.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HouseRobberIII {

    static HashMap<TreeNode, Integer> robbed = new HashMap<>();
    static HashMap<TreeNode,  Integer > notRobbed = new HashMap<>();

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        //solveUsingDp(root);
        //solveUsingRecursion(root);
        solveUsingRecursionAndMemoization(root);
    }

    private static void solveUsingRecursionAndMemoization(TreeNode root) {
        System.out.println(helper2(root, false));
    }

    static int helper2(TreeNode node, boolean robbedParent) {
        if (node == null) {
            return 0;
        }

        if (robbedParent) {
            if (notRobbed.get(node) != null) return  notRobbed.get(node);

            int val = helper2(node.left, false) + helper2(node.right, false);
            notRobbed.put(node, val);
        } else {
            if (robbed.get(node) != null) return  robbed.get(node);

            int val = node.val + helper2(node.left, true) + helper2(node.right, true);
            robbed.put(node, val);
        }

        int robbbedValue = 0;
        int notRobbedValue = 0;

        if (notRobbed.get(node) != null) {
            notRobbedValue = notRobbed.get(node);
        }

        if (robbed.get(node) != null) {
            robbbedValue = robbed.get(node);
        }

        return Math.max(robbbedValue, notRobbedValue);
    }

    private static void solveUsingRecursion(TreeNode root) {
        int[] vals = helper(root);

        System.out.println(vals[0] +" "+vals[1]);
    }

    static int[] helper(TreeNode node) {
        if (node == null) {
            // rob, NotRobbed
            return new int[] {0, 0};
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int robNode = node.val + left[1] + right[1];
        int notRobbed = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return new int[]{robNode, notRobbed};
    }

    private static void solveUsingDp(TreeNode root) {

        ArrayList<Integer> tree = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        int index = -1;
        graph.put(index, new ArrayList<>());

        Queue<TreeNode> q_node = new LinkedList<>();
        q_node.add(root);
        Queue<Integer> q_parentIndex = new LinkedList<>();
        q_parentIndex.add(index);

        while (q_node.size() > 0) {
            TreeNode currentNode = q_node.poll();
            int parentIndex = q_parentIndex.poll();

            if(currentNode != null) {
                index++;
                tree.add(currentNode.val);
                graph.put(index, new ArrayList<>());
                graph.get(parentIndex).add(index);

                q_node.add(currentNode.left);
                q_parentIndex.add(index);

                q_node.add(currentNode.right);
                q_parentIndex.add(index);
            }
        }

        System.out.println(tree);

        int[] dpRob = new int[index + 1];
        int[] dpNotRob = new int[index + 1];

        for (int i = index; i >=0; i--) {
            ArrayList<Integer> children = graph.get(i);
            if (children == null || children.size() == 0) {
                // Leaf node.
                dpRob[i] = tree.get(i);
                dpNotRob[i] = 0;
            } else {
                dpRob[i] = tree.get(i);
                for (int child : children){
                    dpRob[i] += dpNotRob[child];
                    dpNotRob[i] += Math.max(dpNotRob[child], dpRob[child]);
                }
            }
        }

        System.out.println(Math.max(dpNotRob[0], dpRob[0]));
    }

}
