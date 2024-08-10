package com.algo.app.trie.replacewords;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    TrieNode root;

    public App() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    public String getPrefix(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        TrieNode curr = root;
        for (char w : word.toCharArray()) {
            if (curr.children.get(w) == null) {
                return "";
            }
            stringBuilder.append(w);
            if (curr.isWord) {
                return stringBuilder.toString();
            }
            curr = curr.children.get(w);
        }
        return stringBuilder.toString();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String w : words) {
            String replacedWord = getPrefix(w);
            builder.append(replacedWord).append(" ");
        }

        return builder.toString().trim();
    }

    String replace(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char w : word.toCharArray()) {
            stringBuilder.append(w);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
    }
}
