// https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class N_th_Tribonacci_Number {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci_DP(n));
    }

    // using recursion
    public static int tribonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    // using DP
    public static int tribonacci_DP(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve_DP(n, memo);
    }

    private static int solve_DP(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = solve_DP(n - 1, memo) + solve_DP(n - 2, memo) + solve_DP(n - 3, memo);
        return memo[n];
    }
}
