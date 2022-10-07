package com.test.certification;

import java.util.Arrays;

public class App {

    static class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }

        Node next;

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
//        Node node = new Node(1);
//        node.next = new Node(2);
//        node.next.next = new Node(3);
//        node.next.next.next = new Node(4);
//
//        print(node);
//
//        Node newHead = reverse(node);
//        System.out.println();
//
//        print(newHead);

       Byte b = 10;
       Byte b1  = Byte.valueOf("10");

        System.out.println(b == b1);
    }

    static Node reverse (Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

    static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current+ " -> ");
            current = current.next;
        }
    }

}
