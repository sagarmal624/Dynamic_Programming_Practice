package com.example.mongodbpoc.dynamicProgramming.LongestCommonSubsequence;

public class LongestCommonSubsequence {
    static int[][] t = new int[20][20];

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println(topDown(X, Y, m, n));
    }

    public static int resursiveWithMemorize(char[] X, char[] Y, int m, int n) {

        if (m == 0 || n == 0)
            return 0;
        if (t[m][n] != -1)
            return t[m][n];
        if (X[m - 1] == Y[n - 1]) {
            int result = 1 + resursive(X, Y, m - 1, n - 1);
            t[m][n] = result;
            return result;
        } else {
            int p = resursive(X, Y, m - 1, n);
            int q = resursive(X, Y, m, n - 1);
            int result = Math.max(p, q);
            t[m][n] = result;
            return t[m][n];
        }
    }

    public static int topDown(char[] X, char[] Y, int m, int n) {

        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[m][n];
    }

    public static int resursive(char[] X, char[] Y, int m, int n) {

        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return 1 + resursive(X, Y, m - 1, n - 1);
        else {
            int p = resursive(X, Y, m - 1, n);
            int q = resursive(X, Y, m, n - 1);
            return Math.max(p, q);
        }
    }
}
