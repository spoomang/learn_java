package com.algo.app.practice.amazon;

import java.util.*;

public class AS4 {
    public static void main(String[] args) {

        System.out.println(groupAnagramsUsingCount(
                new String[ ]{
                        "bdddddddddd","bbbbbbbbbbc"

                }
        ));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list  = new ArrayList<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String key = String.copyValueOf(chars);

            List<String> l = map.getOrDefault(key, new ArrayList<>());
            l.add(s);
            map.put(key, l);
        }

        for (String k : map.keySet()) {
            list.add(map.get(k));
        }

        return list;
    }

    static List<List<String>> groupAnagramsUsingCount(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        int[] chars = new int[26];

        for (String s : strs) {
            Arrays.fill(chars, 0);
            for (char c : s.toCharArray()) {
                chars[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            System.out.println(Arrays.toString(chars));
            for (int i = 0; i < chars.length; i++) {
                //sb.append("#");
                sb.append(chars[i]);
            }

            System.out.println(sb);

            List<String> l = map.getOrDefault(sb.toString(), new ArrayList<>());
            l.add(s);
            map.put(sb.toString(), l);
        }

        return new ArrayList<>(map.values());
    }
}
