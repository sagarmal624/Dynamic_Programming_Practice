package com.example.mongodbpoc.slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowExample {
    public static int maxSumInSubArray(int arr[], int k) {
        int res = 0;
        for (int i = 0; i < k; i++)
            res += arr[i];
        int current_sum = res;
        for (int i = k; i < arr.length; i++) {
            current_sum = current_sum + arr[i] - arr[i - k];
            res = Math.max(current_sum, res);
        }

        return res;
    }

    public static int largestMaxSubStringNonRepeatingChars(String str) {
        char[] chars = str.toCharArray();
        String s = "";
        int max = 0;
        int i = 0, p = 0;
        while (p < chars.length && i<chars.length) {
            if (s.contains(chars[i] + "")) {
                p++;
                i = p;
                max = Math.max(max, s.length());
                s = "";
            } else
                s = s + chars[i];
            i++;
        }
        return Math.max(max, s.length());

    }

    public static int minSumInSubArray(int arr[], int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }
        int currentSum = sum;
        for (int i = k; i < arr.length; i++) {
            currentSum = currentSum + arr[i] - arr[i - k];
            sum = Math.min(currentSum, sum);

        }
        return sum;
    }

    public static void findFirstNegativeNumberInSubArray(int arr[], int k) {
        int j = 0;
        for (int i = 0; i < arr.length; ) {
            j = 0;
            int p = i;
            while (j < k) {
                if (p < arr.length && arr[p] < 0) {
                    System.out.println(arr[p]);
                    j = k;
                    System.out.println(0);
                    break;
                }
                p++;
                j++;
            }

            if (j == k) {
                i++;
            }
        }
    }

    static void findMaxNumberInSubArray(int arr[], int k) {
        int j = 0;
        for (int i = 0; i < arr.length; ) {
            j = 0;
            int p = i;
            int max = Integer.MIN_VALUE;
            while (j < k) {
                if (p < arr.length) {
                    max = Math.max(max, arr[p]);
                }
                p++;
                j++;
            }
            System.out.println(max);
            if (j == k) {
                i++;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(largestMaxSubStringNonRepeatingChars("aab"));
        //System.out.println(result);
    }
}
