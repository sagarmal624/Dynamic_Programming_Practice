package com.example.mongodbpoc.dynamicProgramming.knapsack.unbounded;

public class MinimumNumOfCoin {
    public static void main(String[] args) {
        int coins[] = {25, 10, 5};
        int sum = 30;
        System.out.println(minimumCoin(coins, sum));
    }

    public static int minimumCoin(int coins[], int sum) {
        int t[][] = new int[coins.length + 1][sum + 1];

        // Initilization row 1
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    t[i][j] = Integer.MAX_VALUE - 1;
                else if (j == 0)
                    t[i][j] = 0;
            }
        }
      // Initilization row 2
        for (int j = 1; j <= sum; j++) {
            if (j % coins[0] == 0) {
                t[1][j] = j / coins[0];
            } else {
                t[1][j] = Integer.MAX_VALUE - 1;
            }
        }
        // for remaining row
        for (int i = 2; i <= coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(t[i][j - coins[i - 1]] + 1, t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[coins.length][sum];
    }
}
