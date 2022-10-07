package com.algo.app.practice.google;

import java.util.*;

public class ArraysAndStringVI {

    public static void main(String[] args) {

        //System.out.println(findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));
        //System.out.println(nextClosestTime("10:55"));
//        System.out.println(expressiveWords("aaa", new String[]{
//                "aaaa"
//        }));

        System.out.println(findReplaceString("abcd", new int[]{
                0, 2
        }, new String[]{"ab","ec"}, new String[]{"eee","ffff"}));
    }

    static List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> list = new ArrayList<>();


        if (nums[0] > lower) {
            int diff = nums[0] - lower;
            if (diff == 1) {
                list.add(lower+"");
            } else if (diff >= 2) {
                list.add(String.format("%d->%d",lower, nums[0] - 1));
            }
        }

        for (int j = 1; j < nums.length; j++) {
                int diff = nums[j] - nums[j - 1];
                if (diff == 2) {
                    list.add(nums[j] - 1+"");
                } else if (diff > 2) {
                    list.add(String.format("%d->%d",nums[j - 1] + 1, nums[j] - 1));
                }
        }

        if (nums[nums.length - 1] < upper) {
            int diff = upper - nums[nums.length - 1];
            if (diff == 1) {
                list.add(upper+"");
            } else if (diff >= 2) {
                list.add(String.format("%d->%d",nums[nums.length - 1] + 1, upper));
            }
        }


        return list;
    }

    static String nextClosestTime(String time) {

        int mins = Integer.parseInt(time.split(":")[1]);

        mins += Integer.parseInt(time.split(":")[0]) * 60;

        HashSet<Integer> set = new HashSet<>();
        for (char c : time.toCharArray()) {
            set.add(c - '0');
        }

        while (true) {
            mins += (mins + 1) % (24 * 60);
            int[] next_arr = {(mins / 60 / 10), (mins / 60 % 10), (mins % 60 / 10), (mins % 60 % 10)};

            boolean isvalid = true;
            for(int i : next_arr) {
                if (!set.contains(i)) {
                    isvalid = false;
                }
            }

            if (isvalid) {
                return String.format("%d%d:%d%d", next_arr[0], next_arr[1], next_arr[2], next_arr[3]);
            }

        }
    }

    static int expressiveWords(String s, String[] words) {
        int result = 0;

        for (String word : words) {
            if (isOk(s, word)) {
                result++;
            }
        }

        return result;
    }

    static boolean isOk(String s, String word) {
        int i = 0, j = 0;
        int cnt1 = 0, cnt2 = 0;

        while (i <s.length() && j < word.length()) {
            cnt1 = 1;
            cnt2 = 1;
            if (s.charAt(i) != word.charAt(j)) return false;
            while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                cnt1++;
            }
            while(j + 1 < word.length() && word.charAt(j) == word.charAt(j + 1)) {
                j++;
                cnt2++;
            }

            if(cnt2 > cnt1) return false;
            if (cnt1 > cnt2 && cnt1 < 3) return false;
            i++;
            j++;
        }

        if (i == s.length() && j == word.length()) return true;

        return false;
    }

    static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        HashMap<Integer, String[]> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], new String[]{sources[i], targets[i]});
        }

        StringBuilder sb = new StringBuilder();

        int last = 0;
        for (int ind: map.keySet()) {
            if (ind != last) {
                sb.append(s, last, ind);
                last = ind;
            }

            String source = map.get(ind)[0];
            String target = map.get(ind)[1];

            String sub = s.substring(ind, Math.min(ind + s.length(), source.length()));
            if (source.equals(sub)){
                sb.append(target);
                last += source.length();
            } else {
                sb.append(sub);
                last += sub.length();
            }

        }

        if (last < s.length()) {
            sb.append(s.substring(last));
        }

        return sb.toString();
    }

}
