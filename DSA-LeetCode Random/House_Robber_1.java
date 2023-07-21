//https://leetcode.com/problems/house-robber/description/

import java.util.Arrays;

public class House_Robber_1 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));
    }

    public static int rob(int[] arr) {
        // return solve(arr, 0);
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return solve_DP(arr, 0, dp);
    }

    // using recursion.
    // shows TLE.
    public static int solve(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        int take = arr[index] + solve(arr, index + 2);
        int notTake = 0 + solve(arr, index + 1);

        return Math.max(take, notTake);
    }

    // usinf DP.
    public static int solve_DP(int[] arr, int index, int[] dp) {
        if (index >= arr.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int take = arr[index] + solve_DP(arr, index + 2, dp);
        int notTake = 0 + solve_DP(arr, index + 1, dp);

        dp[index] = Math.max(take, notTake);

        return dp[index];
    }
}