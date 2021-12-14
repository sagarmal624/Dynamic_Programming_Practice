package com.example.mongodbpoc.faang;

import java.util.Arrays;

public class ArrayProblems {
    public static int removeDuplicates(int nums[]) {
        if (nums.length == 0)
            return 0;
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                counter++;
            }
        }
        return counter;
    }

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                sum = sum + diff;
            }
        }
        return sum;
    }

    static int singleelement(int arr[], int n) {
        int low = 0, high = n - 2;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == arr[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[low];
    }

    public static int[] rotateArrayByK(int nums[], int k) {

        for (int i = 1; i <= k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 4, 5, 3, 4};
        int size = 7;
        Arrays.sort(arr);
        System.out.println(singleelement(arr, size));
    }
}
