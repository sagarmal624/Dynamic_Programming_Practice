package com.example.mongodbpoc.dynamicProgramming.LongestCommonSubsequence;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "Ge1eksforpp";
        String s2 = "GeeksQuiz";
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        System.out.println(topDown(X, Y, m, n));
    }

    public static int topDown(char[] X, char[] Y, int m, int n) {
        int t[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                    max = Math.max(max, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return max;
    }
}
