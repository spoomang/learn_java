package com.learn.design.loadbalancer;


import java.util.*;

class DCLoadBalancer {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(nums));
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);

            break;
        }
    }

    static int longestConsecutiveSubSequence(String s) {
        int max = 0;
        int[] chars = new int[26];
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            chars[c - 'a']++;

            map.put(c, right);
            if (chars[c - 'a'] > 1) {
                int tempMax = 0;
                int count = 0;
                for(int i : chars) {
                    if (i == 0) {
                        count = 0;
                    } else {
                        count++;
                    }
                    tempMax = Math.max(tempMax, count);
                }

                max = Math.max(tempMax, max);
                chars[c - 'a']--;
                right = map.get(c) + 1;
            } else {
                right++;
            }
        }

        int tempMax = 0;
        int count = 0;
        for(int i : chars) {
            if (i == 0) {
                count = 0;
            } else {
                count++;
            }
            tempMax = Math.max(tempMax, count);
        }
        max = Math.max(tempMax, max);
        return max;
    }
}
