//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

import java.util.Arrays;

public class Minimum_Insertion_Steps_to_Make_String_Palindrome {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(minInsertions(s));
    }

    public static int minInsertions(String s) {
        String temp = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            temp += s.charAt(i);
        }

        int[][] dp = new int[s.length()][temp.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // If we know the longest palindromic sub-sequence is x and the length of the
        // string is n
        // then, what is the answer to this problem? It is n - x as we need n - x
        // insertions to
        // make the remaining characters also palindrome.

        int max_pal_subseq_len = LPS_DP(s, temp, 0, 0, dp);

        return s.length() - max_pal_subseq_len;
    }

    // finding the longest palindromic subsequence using recursion.
    public static int LPS(String str, String temp, int i, int j) {
        if (i == str.length() || j == temp.length()) {
            return 0;
        }

        int ans = 0;
        if (str.charAt(i) == temp.charAt(j)) {
            ans = 1 + LPS(str, temp, i + 1, j + 1);
        }

        else {
            ans = Math.max(LPS(str, temp, i + 1, j), LPS(str, temp, i, j + 1));
        }

        return ans;
    }

    // finding the longest palindromic subsequence using DP
    public static int LPS_DP(String str, String temp, int i, int j, int[][] dp) {
        if (i == str.length() || j == temp.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str.charAt(i) == temp.charAt(j)) {
            dp[i][j] = 1 + LPS_DP(str, temp, i + 1, j + 1, dp);
        }

        else {
            dp[i][j] = Math.max(LPS_DP(str, temp, i + 1, j, dp), LPS_DP(str, temp, i, j + 1, dp));
        }

        return dp[i][j];
    }
}
