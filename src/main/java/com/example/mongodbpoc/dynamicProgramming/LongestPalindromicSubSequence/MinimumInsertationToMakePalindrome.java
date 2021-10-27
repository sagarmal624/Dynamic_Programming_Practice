package com.example.mongodbpoc.dynamicProgramming.LongestPalindromicSubSequence;

public class MinimumInsertationToMakePalindrome {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        minimumInsertion(s1);
    }

    public static void minimumInsertion(String s1) {
        int lps = lps(s1);
        System.out.println("Minimum Number of Insertion are:=");
        System.out.println(s1.length() - lps);
    }

    public static int lps(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
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
