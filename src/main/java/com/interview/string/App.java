package com.interview.string;

public class App {

    public static void main(String[] args) {
        String question = "1 +  2 - 3 + 3";
        String question1 = "-2+5 - 3";

        System.out.println(calculateExpression(question1));
    }


    static int calculateExpression(String s) {
        int result = 0;

        s = s.trim();
        s = s.replaceAll("\\s+", "");

        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '+' || curr == '-') {
                operator = curr;
                continue;
            } else {
                if (operator == '+') {
                    result += Integer.parseInt(curr+"");
                } else if (operator == '-') {
                    result -= Integer.parseInt(curr+"");
                }
            }
        }

        return result;
    }

}
