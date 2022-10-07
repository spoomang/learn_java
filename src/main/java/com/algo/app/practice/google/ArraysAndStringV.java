package com.algo.app.practice.google;

import java.util.Collections;
import java.util.HashMap;

public class ArraysAndStringV {
    public static void main(String[] args) {
        System.out.println(minWindow("",  ""));
    }

    static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> dicT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            dicT.put(c, dicT.getOrDefault(c, 0) + 1);
        }

        int required = dicT.size();

        int l = 0;
        int r = 0;
        int formed = 0;
        HashMap<Character, Integer> window = new HashMap<>();


        int[] ans = {-1, l, r};
        while (r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (dicT.containsKey(c) && window.containsKey(c) && dicT.get(c).intValue() == window.get(c).intValue()) {
                formed++;
            }

            while(l <= r && formed == required) {
                c = s.charAt(l);

                if (ans[0] == -1 || ans[0] > r - l + 1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                window.put(c, window.get(c) - 1);
                if (dicT.containsKey(c) && window.get(c).intValue() < dicT.get(c).intValue() ) {
                    formed--;
                }

                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;

        HashMap<Character, Integer> track = new HashMap<>();
        int left = 0;
        int right = 0;
        int max_length = 2;

        while (right < s.length()) {
            char c = s.charAt(right);
            track.put(c, right++);

            if (track.size() == 3) {
                int index_min = Collections.min(track.values());
                track.remove(s.charAt(index_min));
                left = index_min + 1;
            }

            max_length = Math.max(max_length, right - left);
        }

        return max_length;
    }
}
