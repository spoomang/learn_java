package com.algo.app.practice.amazon;

import java.util.*;

public class AS6 {
    public static void main(String[] args) {
        //minMeetingRooms(null);
//        System.out.println(Arrays.toString(topKFrequent(new int[]{
//                1,1,1,2,2,3
//        }, 2)));


        System.out.println(search(new int[]{
            3, 1
        }, 3));
    }


    static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        int numOfRooms = 0;
        int startPointer = 0;
        int endPointer = 0;
        
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        while (startPointer < startTimes.length) {

            if(startTimes[startPointer] >= endTimes[endPointer]) {
                numOfRooms -= 1;
                endPointer++;
            }

            numOfRooms += 1;
            startPointer++;
        }

        return numOfRooms;
    }


    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> Q = new PriorityQueue<>((a1, a2) -> a2[1] - a1[1]);

        for (int key : map.keySet()) {
            Q.add(new int[]{key, map.get(key)});
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int [] ans = Q.poll();
            result[i] = ans[0];
        }



        return result;
    }

    static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int pivot = 0;
        int n = nums.length;

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                pivot = i;
                break;
            }
        }

        System.out.println(pivot);
        int result = Arrays.binarySearch(nums, pivot, n, target);
        System.out.println(target);
        if (result >= 0) {
            return result;
        }

        if (pivot != 0) {
            result = Arrays.binarySearch(nums, 0, pivot , target);
            if (result >= 0) {
                return result;
            }
        }

        return -1;
    }
}
