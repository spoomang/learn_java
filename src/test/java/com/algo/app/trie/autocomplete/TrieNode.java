package com.algo.app.trie.autocomplete;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    Map<String, Integer> sentencesCount = new HashMap<>();
}
