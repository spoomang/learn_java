package com.algo.app.practice.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AS5 {
    public static void main(String[] args) {
        //System.out.println(reorderLogFiles(new String[]{}));


        System.out.println("ball,");
    }

    static String[] reorderLogFiles(String[] logs) {

        Map<String, Integer> map  = new HashMap<>();

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String[] s1 = o1.split(" ", 2);
                String[] s2 = o2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(s2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int cmp = s1[1].compareTo(s2[1]);

                    if (cmp != 0) {
                        return cmp;
                    }
                    return s1[0].compareTo(s2[0]);
                }

                if (isDigit1 && !isDigit2) {
                    return 1;
                } else if (!isDigit1 && !isDigit2) {
                    return -1;
                } else {
                    return 0;
                }

            }
        };

        Arrays.sort(logs, comparator);
        return logs;
    }
}
