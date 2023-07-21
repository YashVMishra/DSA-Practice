//https://leetcode.com/problems/longest-common-subsequence/description/

import java.util.Arrays;

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        // return LCS(text1, text2, 0, 0);
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return LCS_DP(text1, text2, 0, 0, dp);
    }

    // using recursion only.
    public static int LCS(String str1, String str2, int i, int j) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        int ans = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            ans = 1 + LCS(str1, str2, i + 1, j + 1);
        }

        else {
            ans = Math.max(LCS(str1, str2, i + 1, j), LCS(str1, str2, i, j + 1));
        }

        return ans;
    }

    // using DP.
    public static int LCS_DP(String str1, String str2, int i, int j, int[][] dp) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + LCS_DP(str1, str2, i + 1, j + 1, dp);
        }

        else {
            dp[i][j] = Math.max(LCS_DP(str1, str2, i + 1, j, dp), LCS_DP(str1, str2, i, j + 1, dp));
        }

        return dp[i][j];
    }
}
