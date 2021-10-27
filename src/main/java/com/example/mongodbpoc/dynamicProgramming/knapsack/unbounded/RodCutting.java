package com.example.mongodbpoc.dynamicProgramming.knapsack.unbounded;

public class RodCutting {
    public static void main(String[] args) {
        int N = 8;
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int length[] = new int[8];
        for (int i = 0; i < 8; i++) {
            length[i] = i + 1;
        }
        System.out.println(maxProfit(price, length, N));
    }

    public static int maxProfit(int price[], int length[], int N) {
        int t[][] = new int[price.length + 1][N + 1];
        for (int i = 0; i <= price.length; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        for (int i = 1; i <= price.length; i++) {
            for (int j = 1; j <= N; j++) {
                if (length[i - 1] <= j) {
                    t[i][j] = Math.max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[price.length][N];

    }
}
