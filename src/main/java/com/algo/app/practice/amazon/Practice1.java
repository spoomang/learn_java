package com.algo.app.practice.amazon;

import java.util.Arrays;

public class Practice1 {
    public static void main(String[] args) {
        // System.out.println(myAtoi("2147483646"));
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
//        System.out.println(trap(new int[]{4,2,0,3,2,5}));

        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    static int myAtoi(String s) {
        int ans = 0;
        int sign = 1;
        int index = 0;

        while (index < s.length() && s.charAt(index) == ' '){
            index++;
        }

        if (index < s.length()) {
            if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            } else if(s.charAt(index) == '+') {
                index++;
            }
        }

        while (index < s.length()) {
            char c = s.charAt(index);
            if (!Character.isDigit(c)){
                break;
            }
            int num = c - '0';


            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE && num > Integer.MAX_VALUE % 10 )) {

                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = (ans * 10) + num;

            index++;
        }


        return ans * sign;
    }

    static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    static int trap(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if(height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    max += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    max += rightMax - height[right];
                }
                right--;
            }
        }

        return max;
    }


    static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = nums.length -1; i >= 0 ; i--) {
            ans[i] = R * ans[i];
            R *= nums[i];
        }

        return ans;
    }
}
