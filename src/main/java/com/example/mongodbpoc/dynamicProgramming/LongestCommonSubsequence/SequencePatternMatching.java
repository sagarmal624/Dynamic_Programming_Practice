package com.example.mongodbpoc.dynamicProgramming.LongestCommonSubsequence;

//https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
public class SequencePatternMatching {
    public static void main(String[] args) {
        String s1 = "GGT";
        String s2 = "AGGTAB";
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        System.out.println(isMatch(X, Y, m, n));
    }

    public static boolean isMatch(char X[], char Y[], int m, int n) {

        int t[][] = new int[m + 1][n + 1];

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
                    t[i][j] = t[i - 1][j - 1] + 1;
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        int lcsLeng = t[m][n];
        if (lcsLeng == m) {
            return true;
        }
        return false;

    }
}
