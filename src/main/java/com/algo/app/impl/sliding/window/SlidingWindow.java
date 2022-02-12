package com.algo.app.impl.sliding.window;

import com.algo.app.info.IAlgorithm;

public class SlidingWindow implements IAlgorithm {

    @Override
    public void getInput() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void display() {

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,8,9,5,6};
        int k = 3;

        int max = maxSumOfKConsecutiveNumbers(arr, k);
        int maxLengthOfArrayForK = maxLengthOfArrForGivenValueOfK(arr, k);

        System.out.printf("max : "+max);
        System.out.printf("\nmax length of array for given value of k : "+maxLengthOfArrayForK);
    }

    static int maxSumOfKConsecutiveNumbers(int[] arr, int k) {
        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer += arr[i];
        }

        for (int i = k; i < arr.length; i++) {
            int sum = answer + arr[i] - arr[i - k];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    static int maxLengthOfArrForGivenValueOfK(int[] arr, int k) {
        int answer = 0;
        int sum = 0;
        int R = 0;
        for (int L = 0; L < arr.length; L++) {
            if (L >= 1) {
                sum -= arr[L];
            }

            while (R < arr.length && sum + arr[R] <= k) {
                sum += arr[R];
                R++;
            }
            answer = Math.max(answer, R - L);
        }

        return answer;
    }
}
