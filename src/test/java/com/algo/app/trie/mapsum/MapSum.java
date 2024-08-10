package com.algo.app.trie.mapsum;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        int value = Integer.MAX_VALUE;
    }

    TrieNode root;
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (curr.children.get(c) == null) {
                curr.children.put(c, new TrieNode());
            }
        }
        curr.value = val;
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children.get(c) != null) {
               curr = curr.children.get(c);
            } else {
                return -1;
            }
        }

        int result = 0;
        if (curr.value != Integer.MAX_VALUE) {
            result += curr.value;
        }

        for (char c : curr.children.keySet()) {
            result += temp(curr.children.get(c));
        }


        return result;
    }

    int temp (TrieNode node) {
        int result = 0;
        if (node == null) {
            return result;
        }

        if (node.value != Integer.MAX_VALUE) {
            result += node.value;
        }

        for (char c : node.children.keySet()) {
            result += temp(node.children.get(c));
        }


        return result;
    }
}
