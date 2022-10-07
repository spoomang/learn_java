package com.algo.app.practice.google;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArraysAndStringVIII {
    public static void main(String[] args) {
        //System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));

        insertionSort(new int[]{5,4,9,3,2,1});

        System.out.println(new int[][] {
                new int[] {0,30},
                new int[] {5,10},
                new int[] {15,20}
        });
    }

    static int trap(int[] height) {
        int result = 0;

        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    result += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    result += right_max - height[right];
                }
                right--;
            }
        }


        return result;
    }

    static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length -1, nums.length - k);
    }

    static int quickSelect(int[] nums, int left, int right, int k_smallest) {
        int pivot = partition( left, right, nums);
        if (pivot == k_smallest) {
            return nums[pivot];
        } else if (k_smallest > pivot){
            return quickSelect(nums, pivot+1 , right, k_smallest);
        } else {
            return quickSelect(nums, left , pivot - 1, k_smallest);
        }
    }

    static int partition(int left, int right, int[] nums) {
        int pivot = nums[right];

        int store_index = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, store_index);
                store_index++;
            }
        }

        swap(nums, store_index, right);

        return store_index;
    }


    static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j > 0 ; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int minMeetingRooms(int[][] intervals) {

        Queue<Integer> allocator = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o));

        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));

        allocator.add(intervals[0][1]);

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}
