// https://leetcode.com/problems/longest-ideal-subsequence/description/?envType=daily-question&envId=2024-04-25

import java.util.Arrays;

public class Longest_Ideal_Subsequence {
    public static void main(String[] args) {
        String s = "pvjcci";
        int k = 4;
        System.out.println(longestIdealString(s, k));
    }

    public static int longestIdealString(String s, int k) {
        int[][] memo = new int[s.length()][123];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        // return solve(s, k, 0, 0);
        return solve_DP(s, k, 0, 0, memo);
    }

    private static int solve(String s, int k, int index, int value) {
        if (index == s.length()) {
            return 0;
        }

        int take = 0;
        if (index == 0 || value == 0 || Math.abs(s.charAt(index) - value) <= k) {
            take = 1 + solve(s, k, index + 1, s.charAt(index));
        }

        int skip = solve(s, k, index + 1, value);

        return Math.max(take, skip);
    }

    // convert the above code to DP code
    private static int solve_DP(String s, int k, int index, int value, int[][] memo) {
        if (index == s.length()) {
            return 0;
        }

        if (memo[index][value] != -1) {
            return memo[index][value];
        }

        int take = 0;
        if (index == 0 || value == 0 || Math.abs(s.charAt(index) - value) <= k) {
            take = 1 + solve_DP(s, k, index + 1, s.charAt(index), memo);
        }

        int skip = solve_DP(s, k, index + 1, value, memo);

        memo[index][value] = Math.max(take, skip);
        return memo[index][value];
    }
}
