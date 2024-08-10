package com.algo.app.leetcode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
     static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        ListNode node3 = new ListNode(2);

        System.out.println(mergeKLists(new ListNode[]{node1, node2, node3}).val);
    }

    static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode listNode : lists) {
            q.add(listNode);
        }

        while (!q.isEmpty()) {
            ListNode node = q.poll();
            dummy.next = node;

            if (node.next != null) {
                q.add(node.next);
            }

            dummy = dummy.next;
        }

        return temp.next;
    }
}
