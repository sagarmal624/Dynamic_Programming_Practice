package com.example.mongodbpoc.dynamicProgramming.LongestPalindromicSubSequence;

//https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
public class LongestPalindromicSubSequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = new StringBuilder(s1).reverse().toString();
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        System.out.println(longestPaliendromeString(X, Y, m, n));
    }

        public static int longestPaliendromeString(char X[], char Y[], int m, int n) {

        return lcs(X, Y, m, n);
    }

    public static int lcs(char X[], char Y[], int m, int n) {

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
        return t[m][n];
    }
}
