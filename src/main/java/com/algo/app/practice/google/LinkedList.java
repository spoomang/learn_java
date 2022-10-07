package com.algo.app.practice.google;

public class LinkedList {

    static class ListNode {
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

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        int carry = 0;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }

            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            if (sum > 9) {
                temp.next = new ListNode(sum % 10);
                carry = 1;
            } else {
                temp.next = new ListNode(sum);
                carry = 0;
            }



            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            temp = temp.next;
        }

        if (carry == 1) {
            temp.next = new ListNode(1);
        }


        return head.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;

        ListNode temp = newNode;
        ListNode temp1 = newNode;
        int i = 0;

        while (temp !=  null) {
            if (i > n) {
                temp1 = temp1.next;
            }
            i++;
            temp = temp.next;
        }

        ListNode nodeTobeRemoved = temp1.next;

        if (nodeTobeRemoved != null) {
            temp1.next = nodeTobeRemoved.next;
        } else {
            temp1.next = null;
        }

        return newNode.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (true) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                temp.next = list1;
                list1 = list1.next;
            } else if (list1 != null) {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;

            if (list1 == null && list2 == null) {
                break;
            }
        }

        return head.next;
    }

    public Node copyRandomList(Node head) {
        Node ptr = head;

        while (ptr != null) {
            Node newNode = new Node(ptr.val);

            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        while (ptr != null) {
            ptr.next.random = (ptr.random == null) ? null : ptr.random.next;
            ptr = ptr.next.next;
        }

        Node oldHead = head.next;
        Node ptr_old = head;
        Node ptr_new = head.next;
        while (ptr_old != null) {
            ptr_old.next = ptr_old.next.next;
            ptr_new.next = (ptr_new.next != null) ? ptr_new.next.next : null;

            ptr_old = ptr_old.next;
            ptr_new = ptr_new.next;
        }
        return oldHead;
    }
}
