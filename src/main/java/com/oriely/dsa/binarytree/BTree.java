package com.oriely.dsa.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BTree {
    Node root;

    public Node find(int id) {
        Node current = root;

        while (current.data != id) {
            if (id < current.data){
                current = current.left;
            } else {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }

        return current;
    }

    void insert(int id) {
        Node node = new Node(id);

        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (id < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }

    }

    void delete(int id) {

        Node delNode = root;
        Node current = root;
        Node parent = root;

        while(current.data != id) {
            parent = current;
            if (id > current.data) {
                // Go Right
                current = current.right;
            } else {
                // Go Left
                current = current.left;
            }

            if (current == null) {
                // Node does not exist
                return;
            }
        }

        // Type 1 - Node is a leaf branch
        if (current.left == null && current.right == null) {

        }

    }

    void display() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();

                System.out.print(n);

                if (n.left != null) {
                    q.add(n.left);
                }

                if (n.right != null) {
                    q.add(n.right);
                }

            }

            System.out.println();
        }
    }
}
