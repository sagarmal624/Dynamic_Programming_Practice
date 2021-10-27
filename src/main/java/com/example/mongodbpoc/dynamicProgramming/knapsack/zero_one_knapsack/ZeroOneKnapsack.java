package com.example.mongodbpoc.dynamicProgramming.knapsack.zero_one_knapsack;

public class ZeroOneKnapsack {
    static int profit[] = new int[4];
// Top Down Tabularization

    public static int topDown(int v[], int w[], int W, int n) {
        int t[][] = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] <= j) {
                    t[i][j] = Math.max(v[i - 1] + t[i - 1][j - w[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][W];

    }

    // n*w time
    public static int recursiveWithMemorize(int v[], int w[], int W, int n) {
        if (n == 0 || W == 0)
            return 0;
        if (profit[n - 1] != -1)
            return profit[n - 1];
        if (w[n - 1] <= W) {
            int p = Math.max(v[n - 1] + recursive(v, w, W - w[n - 1], n - 1), recursive(v, w, W, n - 1));
            profit[n - 1] = p;
            return p;
        } else {
            int p = recursive(v, w, W, n - 1);
            profit[n - 1] = p;
            return p;
        }
    }

    //2 ^n time
    public static int recursive(int v[], int w[], int W, int n) {
        if (n == 0 || W == 0)
            return 0;
        if (w[n - 1] <= W) {
            return Math.max(v[n - 1] + recursive(v, w, W - w[n - 1], n - 1), recursive(v, w, W, n - 1));
        } else {
            return recursive(v, w, W, n - 1);
        }
    }

    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

        int v[] = {60, 100, 120};
        int w[] = {10, 20, 30};
        //for Memorization Purpose
        for (int i = 0; i < 4; i++) {
            profit[i] = -1;
        }
        int maxProfit = topDown(v, w, 50, 3);

        System.out.println(maxProfit);

    }
}
