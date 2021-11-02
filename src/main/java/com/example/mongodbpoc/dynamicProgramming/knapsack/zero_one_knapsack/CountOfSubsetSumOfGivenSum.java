package com.example.mongodbpoc.dynamicProgramming.knapsack.zero_one_knapsack;

public class CountOfSubsetSumOfGivenSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3};
        int size = count(arr, 6);
        System.out.println(size);
    }

    public static int count(int arr[], int sum) {
        int t[][] = new int[arr.length + 1][sum + 1];
        int n = arr.length + 1;
        int w = sum + 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < w; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
}
