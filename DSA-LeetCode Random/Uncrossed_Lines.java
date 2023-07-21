//https://leetcode.com/problems/uncrossed-lines/description/

import java.util.Arrays;

public class Uncrossed_Lines {
    public static void main(String[] args) {
        int[] nums1 = { 2, 5, 1, 2, 5 };
        int[] nums2 = { 10, 5, 2, 1, 5, 2 };
        System.out.println(maxUncrossedLines(nums1, nums2));
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        // return solve(nums1, nums2, 0, 0);

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solve_DP(nums1, nums2, 0, 0, dp);
    }

    // everything is same as Longest Common Subsequence.
    // using recursion.
    public static int solve(int[] nums1, int[] nums2, int i, int j) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        int ans = 0;
        if (nums1[i] == nums2[j]) {
            ans = 1 + solve(nums1, nums2, i + 1, j + 1);
        }

        else {
            ans = Math.max(solve(nums1, nums2, i + 1, j), solve(nums1, nums2, i, j + 1));
        }

        return ans;
    }

    // everything is same as Longest Common Subsequence.
    // using DP
    public static int solve_DP(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i] == nums2[j]) {
            dp[i][j] = 1 + solve_DP(nums1, nums2, i + 1, j + 1, dp);
        }

        else {
            dp[i][j] = Math.max(solve_DP(nums1, nums2, i + 1, j, dp), solve_DP(nums1, nums2, i, j + 1, dp));
        }

        return dp[i][j];
    }
}
