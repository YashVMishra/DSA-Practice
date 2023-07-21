//https://leetcode.com/problems/longest-palindromic-subsequence/description/

import java.util.Arrays;

public class Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    // we will use the modification of Longest common subsequence (LCS).
    // that is we will reverse the given string and then do the
    // LCS of the given string and the reverse of it
    // this will give us the Longest Palindromic Subsequence
    public static int longestPalindromeSubseq(String s) {
        String temp = "";

        // reversing the string.
        for (int i = s.length() - 1; i >= 0; i--) {
            temp += s.charAt(i);
        }

        // creating DP array.
        int[][] dp = new int[s.length()][temp.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return LPS_DP(s, temp, 0, 0, dp);
    }

    // using recursion.
    public static int LPS(String str1, String str2, int i, int j) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        int ans = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            ans = 1 + LPS(str1, str2, i + 1, j + 1);
        }

        else {
            ans = Math.max(LPS(str1, str2, i + 1, j), LPS(str1, str2, i, j + 1));
        }

        return ans;
    }

    // using DP
    public static int LPS_DP(String str1, String str2, int i, int j, int[][] dp) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + LPS_DP(str1, str2, i + 1, j + 1, dp);
        }

        else {
            dp[i][j] = Math.max(LPS_DP(str1, str2, i + 1, j, dp), LPS_DP(str1, str2, i, j + 1, dp));
        }

        return dp[i][j];
    }
}
