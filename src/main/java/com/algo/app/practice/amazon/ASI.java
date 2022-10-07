package com.algo.app.practice.amazon;

import java.util.HashMap;
import java.util.Map;

public class ASI {

    static Map<Integer, String> map = new HashMap() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    static Map<String, Integer> map1 = new HashMap() {{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};

    public static void main(String[] args) {

//        System.out.println(lengthOfLongestSubstring("bcaa"));
//        System.out.println(myAtoi("   -2147483648dasd"));
//        System.out.println(intToRoman(3));
        System.out.println(romanToInt("MCMXCIV"));
    }

    static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> chars = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            chars.put(c, chars.getOrDefault(c, 0) + 1);

            while (chars.get(c) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.getOrDefault(l, 0) - 1);
                left++;
            }

            max = Math.max(right - left + 1, max);

            right++;
        }

        return max;
    }

    static int myAtoi(String s) {
        int index = 0;
        int result = 0;
        int n = s.length();

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        int sign = 1;

        if (index < n && s.charAt(index) == '-') {
            sign = -1;
        }

        if (index < n && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            index++;
        }

        while (index < s.length()) {
            char c = s.charAt(index);
            if (!Character.isDigit(c)) {
                break;
            }
            int number = c - '0';

            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && number > Integer.MAX_VALUE % 10)) {

                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + number;

            index++;
        }


        return result * sign;
    }

    static String intToRoman(int num) {
        int[] nums = {
                1000,
                900,
                500,
                400,
                100,
                90,
                50,
                40,
                10,
                9,
                5,
                4,
                1
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (num / nums[i] > 0) {
                for (int j = 0; j < num / nums[i]; j++) {
                    sb.append(map.get(nums[i]));
                }
                num = num % nums[i];
            }
        }

        return sb.toString();
    }

    static int romanToInt(String s) {
        int result = 0;
        int i = 0;

        String sub = "";
        while (i < s.length()) {
            if (i + 2 <= s.length() && map1.containsKey(s.substring(i, i + 2))) {
                sub = s.substring(i, i + 2);
                i += 2;
            } else {
                sub = s.substring(i, i + 1);
                i++;
            }
            result += map1.get(sub);

        }

        return result;
    }

}
