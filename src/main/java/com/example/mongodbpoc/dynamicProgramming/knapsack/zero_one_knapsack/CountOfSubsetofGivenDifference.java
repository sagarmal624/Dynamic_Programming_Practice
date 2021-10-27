package com.example.mongodbpoc.dynamicProgramming.knapsack.zero_one_knapsack;

//https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11


// Target Sum-- Both are same
//https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
public class CountOfSubsetofGivenDifference {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3};
        System.out.println(count(arr, 1));
    }

    public static int count(int arr[], int diff) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        int subsetSum = (diff + sum) / 2;
        return countOfSubsetSum(arr, subsetSum);
    }

    public static int countOfSubsetSum(int arr[], int sum) {
        int[][] t = new int[arr.length + 1][sum + 1];

        for (int i = 0; i <= arr.length; i++) {

            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }

        }
        for (int i = 1; i <= arr.length; i++) {

            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }

        }
        return t[arr.length][sum];

    }
}
