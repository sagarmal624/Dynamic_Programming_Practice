package com.example.mongodbpoc.dynamicProgramming.knapsack.unbounded;

public class TotalWayOfCoinChange {
    public static void main(String[] args) {
        int coins[] = {2, 5, 3, 6};
        int amount = 10;
        System.out.println(count(coins, amount));
    }

    public static int count(int coins[], int amount) {

        int t[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (i == 0)
                    t[i][j] = 0;
                else if (j == 0)
                    t[i][j] = 1;
            }
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[coins.length][amount];

    }
}
