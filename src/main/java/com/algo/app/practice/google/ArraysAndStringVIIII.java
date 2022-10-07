package com.algo.app.practice.google;

import java.util.Stack;

public class ArraysAndStringVIIII {

    public static void main(String[] args) {

        //System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("bxo#j##tw", "dasd"));
    }

    static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    static String build(String s ) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

       return String.valueOf(stack);
    }
}
