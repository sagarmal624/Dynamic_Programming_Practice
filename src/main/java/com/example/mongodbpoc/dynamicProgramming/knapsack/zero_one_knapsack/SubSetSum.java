package com.example.mongodbpoc.dynamicProgramming.knapsack.zero_one_knapsack;

public class SubSetSum {


    public static boolean topDown(int w[], int W, int n) {

        boolean t[][] = new boolean[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (w[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - w[i - 1]] || t[i - 1][j];
                } else
                    t[i][j] = t[i - 1][j];
            }

        }
        return t[n][W];
    }
   // not working properly.. need to optimize
    public static boolean resursive(int w[], int W, int n) {
        if (n == 0)
            return false;

        if (W == 0)
            return true;

        if (w[n - 1] <= W) {
            return resursive(w, W - w[n - 1], n - 1) || resursive(w, W, n - 1);
        }
        return resursive(w, W, n - 1);
    }

    public static void main(String[] args) {
        int w[] = {1, 3, 7, 9};
        System.out.println(topDown(w, 16, 4));
    }
}
