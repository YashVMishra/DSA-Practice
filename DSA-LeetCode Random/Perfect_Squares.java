// https://leetcode.com/problems/perfect-squares/description/?envType=daily-question&envId=2024-02-08

import java.util.Arrays;

public class Perfect_Squares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        // return solve(n);

        // if ypu want to run method solve_2 then run the below code.
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // return solve_2(n, dp);

        // if you want to run the method solve_3 then run the below code.
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return solve_DP(n, dp);
    }

    // using recursion.
    public static int solve(int n) {
        if (n == 0) {
            return 0;
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int result = 1 + solve(n - i * i);
            minCount = Math.min(minCount, result);
        }

        return minCount;
    }

    // using dp
    public static int solve_DP(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int result = 1 + solve_DP(n - i * i, dp);
            minCount = Math.min(minCount, result);
        }

        return dp[n] = minCount;
    }
}
