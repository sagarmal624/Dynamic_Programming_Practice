package com.example.mongodbpoc.dynamicProgramming.knapsack.zero_one_knapsack;

public class EqualSum {

    public static void main(String[] args) {
        int arr[] = {1, 5, 5, 11};
        System.out.println(isEqualSum(arr));
    }

    public static boolean isEqualSum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 == 0) {
            sum = sum / 2;

            boolean t[][] = new boolean[arr.length + 1][sum + 1];

            for (int i = 0; i <= arr.length; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (i == 0)
                        t[i][j] = false;
                    if (j == 0)
                        t[i][j] = true;
                }
            }
            for (int i = 1; i <= arr.length; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (arr[i - 1] <= j) {
                        t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                    } else {
                        t[i][j] = t[i - 1][j];
                    }
                }
            }
            return t[arr.length][sum];

        } else {
            return false;
        }
    }
}
