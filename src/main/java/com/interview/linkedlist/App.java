package com.interview.linkedlist;

public class App {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        print(node1);
        int n = 2;
        ListNode head = removeNthFromEnd1(node1, n);
        print(head);
    }

    static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val+" -> ");
            node = node.next;
        }
        System.out.println();
    }


    static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = head;
        while (first != null) {
            first = first.next;
            length++;
        }
        System.out.println("length : "+length);
        length -= n;

        System.out.println("traverse length : "+length);
        first = dummy;
        for (int i = 0; i < length; i++) {
            first = first.next;
        }

        first.next = first.next.next;

        return dummy.next;
    }

    static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

}
