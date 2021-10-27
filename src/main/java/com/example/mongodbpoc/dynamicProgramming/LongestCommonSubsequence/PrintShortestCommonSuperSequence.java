package com.example.mongodbpoc.dynamicProgramming.LongestCommonSubsequence;

//https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24
public class PrintShortestCommonSuperSequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        System.out.println(print(X, Y, m, n));
    }

    public static String print(char X[], char Y[], int m, int n) {

        int t[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;

            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1])
                    t[i][j] = 1 + t[i - 1][j - 1];
                else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        int i = m, j = n;
        String str = "";
        while (i > 0 && j > 0) {

            if (X[i - 1] == Y[j - 1]) {
                str = str + X[i - 1];
                i--;
                j--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    str = str + X[i - 1];
                    i--;
                } else {
                    str = str + Y[j - 1];
                    j--;
                }
            }
        }
        while (i > 0) {
            str = str + X[i - 1];
            i--;
        }
        while (j > 0) {
            str = str + Y[j - 1];
            j--;
        }
        return new StringBuilder(str).reverse().toString();
    }
}
