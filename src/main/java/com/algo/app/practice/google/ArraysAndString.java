package com.algo.app.practice.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysAndString {
    public static void main(String[] args) {

        System.out.println(longestSubStringWithoutRepeatingChars("au"));
        System.out.println(containerWithMostWater(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSumII(new int[]{2,7,11,15}, 9)));
    }

    static int longestSubStringWithoutRepeatingChars(String str) {
        int max = 0;
        int[] chars = new int[128];

        int left = 0;
        int right = 0;
        while(right < str.length()) {
            char c = str.charAt(right);
            chars[c]++;

            while(chars[c] > 1) {
                int leftChar = str.charAt(left);
                chars[leftChar]--;
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    static int containerWithMostWater(int[] heights) {
        int x1 = 0, x2 = heights.length - 1;

        int max = 0;
        while (x1 < x2) {
            int y1 = heights[x1], y2 = heights[x2];
            max = Math.max(max, (x2 - x1) * Math.min(y1, y2));

            if (heights[x1] < heights[x2]) {
                x1++;
            } else {
                x2--;
            }
        }
        return max;
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement =  target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
        }

        return null;
    }

    static int[] twoSumII(int[] nums, int target) {
        int x1 = 0;
        int x2 = nums.length - 1;

        while(x1 < x2) {

            if (nums[x1] + nums[x2] > target) {
                x2--;
            } else if (nums[x1] + nums[x2] < target) {
                x1++;
            } else{
                return new int[]{x1 + 1, x2 + 1 };
            }


        }


        return null;
    }

}
