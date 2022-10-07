package com.algo.app.practice.amazon;

public class LL1 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static void print(ListNode node) {

        while (node != null) {
            System.out.print(node.val+ " -> ");
            node = node.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

    }
}
