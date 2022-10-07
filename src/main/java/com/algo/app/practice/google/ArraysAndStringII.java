package com.algo.app.practice.google;

import java.lang.reflect.Array;
import java.util.*;

public class ArraysAndStringII {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4, 1, -1, 2}));
        System.out.println(threeSumNoSort(new int[]{-1,0,1,2,-1,-4, 1, -1, 2}));

        System.out.println(threeSumSmaller(new int[] {-2,0,1,3}, 2));
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumHasSet(nums, i, res);
            }
        }
        return res;
    }

    static void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;

        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi] ;
            if (sum < 0) {
                lo++;
            } else if (sum > 0) {
                hi--;
            } else {
                res.add(Arrays.asList(nums[i] , nums[lo++], nums[hi--]));
                while(lo < hi && nums[lo] == nums[lo -1]){
                    lo++;
                }
            }
        }
    }

    static void twoSumHasSet(int[] nums, int i, List<List<Integer>> res) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while(j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            seen.add(nums[j]);
        }
    }

    static List<List<Integer>> threeSumNoSort(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = -nums[j] - nums[i];
                    if(seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(list);
                        res.add(list);
                    }
                    seen.put(nums[j], i);
                }
            }
            
        }

        return new ArrayList<>(res);
    }

    static int threeSumSmaller(int[] nums, int target) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmallerII(nums, i  + 1, target - nums[i]);
        }

        return sum;
    }

    static int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }

        return sum;
    }

    static int twoSumSmallerII(int[] nums, int startIndex, int target) {
        int sum  = 0;

        for (int i = startIndex; i < nums.length; i++) {
            int k = binarySearch(nums, i , target - nums[i]);
            sum += k - i;
        }

        return sum;
    }

    static int binarySearch(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }

        }
        
        return left;
    }
}
