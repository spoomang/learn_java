package com.algo.app.practice.google;

import java.util.Arrays;

public class ArraysAndStringIII {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(plusOne(new int[]{9, 8})));
//        System.out.println(Arrays.toString(plusOneElegant(new int[]{9, 9})));
//        System.out.println(addBinary("11", "1"));
//        System.out.println(addNumbers("11", "9"));

        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        reverse(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    
    static int[] plusOne(int[] digits) {

        int carry = 0;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            int plusOne = i == digits.length - 1 ? 1 : 0;
            int sum = digits[i] + plusOne + carry;

            if (sum > 9) {
                digits[i] = sum - 10;
                carry = 1;
            } else {
                digits[i] = sum;
                carry = 0;
            }
        }

        if (carry >= 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i <= digits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }

        return digits;
    }

    static int[] plusOneElegant(int[] digits) {

        for (int i = digits.length - 1; i >= 0 ; i--) {

            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }

        }

        digits =  new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }


    static String addBinary(String a, String b) {
        char[] c1, c2;

        if (a.length() > b.length()) {
            c1 = a.toCharArray();
            c2 = b.toCharArray();
        } else {
            c2 = a.toCharArray();
            c1 = b.toCharArray();
        }

        StringBuffer sb = new StringBuffer();

        int j = c2.length - 1;
        int carry = 0;
        for (int i = c1.length - 1; i >= 0 ; i--) {
            if (c1[i] == '1') carry++;
            if (j >= 0 && c2[j--] == '1') carry++;

            if (carry % 2 == 1) sb.append('1');
            else sb.append('0');

            carry /= 2;
        }

        if (carry == 1) sb.append("1");

        return sb.reverse().toString();
    }

    static String addNumbers(String a, String b) {
        StringBuffer sb = new StringBuffer();

        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;
        while(p1 >=0 || p2 >= 0) {

            int x1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            int sum = x1 + x2 + carry;
            int value = sum % 10;
            sb.append(value);

            carry = sum / 10;

            p1--;
            p2--;
        }

        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n- 1- j][i];
                matrix[n- 1- j][i] = matrix[n- 1 - i][n- 1- j];
                matrix[n- 1 - i][n- 1- j] = matrix[j][n- 1- i];
                matrix[j][n- 1- i] = temp;
                System.out.print(matrix[i][j] +" ");
                System.out.print(matrix[j][n- 1- i]+" ");
                System.out.print(matrix[n- 1 - i][n- 1- j]+" ");
                System.out.print(matrix[n- 1- j][i]+" ");
                System.out.println();
            }
        }
    }

    static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]= temp;
            }
        }

    }

    static void reverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
