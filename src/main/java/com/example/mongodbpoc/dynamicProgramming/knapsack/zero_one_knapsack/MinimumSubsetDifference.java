package com.example.mongodbpoc.dynamicProgramming.knapsack.zero_one_knapsack;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
public class MinimumSubsetDifference {

    public static void main(String[] args) {
        int arr[] = {1, 2, 7};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println(minimum(arr, sum));
    }

    public static int minimum(int arr[], int range) {

        boolean t[][] = new boolean[arr.length + 1][range + 1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= range; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[j][j] = true;
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= range; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                } else
                    t[i][j] = t[i - 1][j];
            }
        }
        List<Integer> s1 = new ArrayList<>();
        for (int i = 0; i <= range / 2; i++) {
            if (t[arr.length][i]) {
                s1.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s1.size(); i++) {
            min = Math.min(min, range - 2 * s1.get(i));
        }
        return min;
    }
}
