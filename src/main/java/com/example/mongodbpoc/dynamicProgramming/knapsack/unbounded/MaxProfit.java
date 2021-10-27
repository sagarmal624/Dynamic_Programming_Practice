package com.example.mongodbpoc.dynamicProgramming.knapsack.unbounded;

public class MaxProfit {
    public static void main(String[] args) {
        int val[] = {1, 4, 5, 7};
        int wt[] = {1, 3, 4, 5};
        int N = 4, W = 8;
        System.out.println(maxProfit(val, wt, W, N));
    }

    public static int maxProfit(int p[], int w[], int W, int n) {
        int t[][] = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] <= j) {
                    t[i][j] = Math.max(p[i - 1] + t[i][j - w[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][W];
    }
}
