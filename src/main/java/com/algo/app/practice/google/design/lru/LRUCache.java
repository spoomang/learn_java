package com.algo.app.practice.google.design.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        int key;
        int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    int size;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {

        Node node = map.getOrDefault(key, null);
        if (node ==  null) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            size++;

            if (size > capacity) {
                Node last = popTail();
                map.remove(last.key);
            }

        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    void moveToHead(Node node) {
        deleteNode(node);
        addNode(node);
    }

    Node popTail() {
        Node last = tail.prev;
        deleteNode(last);
        return last;
    }

}
