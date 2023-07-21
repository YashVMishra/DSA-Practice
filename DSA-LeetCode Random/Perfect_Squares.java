//https://leetcode.com/problems/perfect-squares/description/

import java.util.Arrays;

public class Perfect_Squares {
    public static void main(String[] args) {
        System.out.println(numSquares(5));
    }

    public static int numSquares(int n) {
        // return solve(n);

        // if ypu want to run method solve_2 then run the below code.
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // return solve_2(n, dp);

        // if you want to run the method solve_3 then run the below code.
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve_3(n, dp);
    }

    // using recursion.
    public static int solve_1(int n) {
        if (n == 0) {
            return 0;
        }

        int ans = n;
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + solve_1(n - i * i));
        }

        return ans;
    }

    // using dp
    public static int solve_2(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }

        for (int i = 1; i * i <= n; i++) {
            dp[n] = Math.min(dp[n], 1 + solve_2(n - i * i, dp));
        }

        return dp[n];
    }

    // using dp ... just a little bit of change.
    public static int solve_3(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = n;
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + solve_3(n - i * i, dp));
        }

        dp[n] = ans;
        return dp[n];
    }
}
