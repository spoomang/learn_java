package com.algo.app.practice.google;

import org.w3c.dom.ls.LSInput;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ArraysAndStringVII {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val+" -> ";
        }

        static void print(ListNode node) {
            ListNode temp = node;
            while (temp != null) {
                System.out.print(temp);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {

//        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
//        System.out.println(isValid("()"));
        //System.out.println(mergeKLists(null));
        mergeKListsPriortyQ(null);
    }

    static int maxDistToClosest(int[] seats) {
        int max = 0;
        int left = 0;
        int right = 0;

        while (left < seats.length && right < seats.length) {
            right = left + 1;
            while (right < seats.length && seats[right] == 0) right++;

            if (right == seats.length) {
                max = Math.max(max, right - left - 1);
            } else {
                if (seats[left] == 0) {
                    max = Math.max(max, right - left);
                } else {
                    max = Math.max(max, (right - left) / 2);
                }
            }


            left = right;
        }

        return max;
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }


    static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        int min_index = 0;
        ListNode h = head;
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        min_index = i;
                    }
                    isBreak = false;
                }
            }

            if(isBreak) {
                break;
            }

            h.next = new ListNode(lists[min_index].val);
            h = h.next;
            lists[min_index] = lists[min_index].next;
        }


        return head.next;
    }

    static ListNode mergeKListsPriortyQ(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        Queue<ListNode> queue = new PriorityQueue<>(cmp);

        for (ListNode node: lists) {
            if (node !=  null) {
                queue.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode point = head;

        while (!queue.isEmpty()) {
            ListNode nodeWithMinimumValue = queue.poll();
            point.next = nodeWithMinimumValue;
            point = point.next;

            if (nodeWithMinimumValue.next != null) {
                queue.add(nodeWithMinimumValue.next);
            }
        }


        return head.next;
    }
}


