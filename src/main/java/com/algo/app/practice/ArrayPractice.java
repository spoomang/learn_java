package com.algo.app.practice;

import java.util.Arrays;

public class ArrayPractice {

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int m = 3;
        int[] num2 = {2,5,6};
        int n = 3;

        merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));

        int[] nums= {1,0,2,3,0,4,5,0};
        duplicateZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void duplicateZeros(int[] nums) {
        int numOfDuplicate = 0;
        int length = nums.length - 1;

        for (int i = 0; i < length - numOfDuplicate; i++) {
            if (nums[i] == 0) {

                if (i == length - numOfDuplicate) {
                    nums[length] = 0;
                    length--;
                    break;
                }

                numOfDuplicate++;
            }
        }

        int last = length - numOfDuplicate;

        for (int i = last; i >= 0; i--) {
            if (nums[i] == 0) {
                nums[i + numOfDuplicate] = 0;
                numOfDuplicate--;
                nums[i + numOfDuplicate] = 0;
            } else {
                nums[i + numOfDuplicate] = nums[i];
            }
        }

    }


    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];

        for (int i = 0; i < m; i++) {
            nums[i] = nums1[i];
        }

        int j = 0, k= 0;
        for (int i = 0; i < nums1.length; i++) {
            if (j < m && k < n) {
                if (nums[j] < nums2[k]) {
                    nums1[i] = nums[j++];
                } else {
                    nums1[i] = nums2[k++];
                }
            } else {
                if (k < n) {
                    nums1[i] = nums2[k++];
                }
                if (j < m) {
                    nums1[i] = nums[j++];
                }
            }
        }

    }
}
