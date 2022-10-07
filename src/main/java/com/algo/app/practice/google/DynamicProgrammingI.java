package com.algo.app.practice.google;

public class DynamicProgrammingI {

    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[] {
                -2,1,-3,4,-1,2,1,-5,4
        }));
    }

    static int maxSubArray(int[] nums) {
        int currArrSum = nums[0];
        int maxArrSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            currArrSum = Math.max(num, num + currArrSum);
            maxArrSum = Math.max(maxArrSum, currArrSum);
        }

        return maxArrSum;
    }

    static int maxSubArray1(int[] nums) {
        return findBestSubarray(nums, 0, nums.length - 1);
    }


    static int findBestSubarray(int[] nums, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }

        int mid = Math.floorDiv(left + right, 2);

        int leftBestSum = 0;
        int rightBestSum = 0;

        int curr = 0;
        for (int i = mid - 1; i >= left  ; i--) {
            curr += nums[i];
            leftBestSum = Math.max(curr, leftBestSum);
        }

        curr = 0;
        for (int i = mid + 1; i < right; i++) {
            curr += nums[i];
            rightBestSum = Math.max(curr, rightBestSum);
        }

        int bestCombined = nums[mid] + leftBestSum + rightBestSum;

        int leftHalf = findBestSubarray(nums, left, mid - 1);
        int rightHalf = findBestSubarray(nums, mid + 1, right);

        return Math.max(bestCombined, Math.max(leftHalf, rightHalf));
    }

    static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = tempMax;

            result = Math.max(result, max_so_far);
        }

        return result;
    }
}
