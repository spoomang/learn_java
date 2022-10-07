package com.algo.app.practice.amazon;

import java.util.*;

public class AS2 {
    public static void main(String[] args) {
//        System.out.println(threeSum(new int[] {
//                -1,0,1,2,-1,-4
//        }));

//        System.out.println(threeSumClosest(
//                new int[] {1,2,1,-4},
//                1
//        ));

        System.out.println(strStr("mississippi", "issipi"));
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i ==0 || (nums[i] != nums[i - 1])) {
                twoSum(nums, i, list);
            }
        }

        return list;
    }

    static void twoSum(int[] nums, int i,  List<List<Integer>> list) {
        int lo = i + 1;
        int hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                lo++;
            } else if (sum > 0) {
                hi--;
            } else {
                list.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
            }
        }
    }

    static void twoSumHashSet(int[] nums, int i,  List<List<Integer>> list) {
        Set<Integer> set = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {

        }
    }

    static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];

                if (Math.abs(sum - target) < Math.abs(diff)) {
                    diff = target - sum;
                }

                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return target - diff;
    }


    static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;

        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean isMatch = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (i + j >= haystack.length() ||  needle.charAt(j) != haystack.charAt(i + j)){
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    index = i;
                    break;
                }
            }
        }
        
        return index;
    }
}
