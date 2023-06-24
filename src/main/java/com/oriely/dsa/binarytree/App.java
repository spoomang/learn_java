package com.oriely.dsa.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        BTree bTree = new BTree();

        bTree.insert(15);
        bTree.insert(10);
        bTree.insert(20);

        bTree.insert(9);
        bTree.insert(11);

        bTree.insert(16);
        bTree.insert(22);

        bTree.display();
    }


    static void display(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                System.out.print(node);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            System.out.println();
        }
    }
}
