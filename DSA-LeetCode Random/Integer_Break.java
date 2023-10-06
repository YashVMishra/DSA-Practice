// https://leetcode.com/problems/integer-break/description/?envType=daily-question&envId=2023-10-06

import java.util.Arrays;

public class Integer_Break {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve_DP(n, memo);
    }

    private static int solve(int n) {
        if (n == 1) {
            return 1;
        }

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            int product = i * Math.max(n - i, solve(n - i));
            result = Math.max(result, product);
        }

        return result;
    }

    private static int solve_DP(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            int product = i * Math.max(n - i, solve_DP(n - i, memo));
            result = Math.max(result, product);
        }

        memo[n] = result;
        return result;
    }
}
