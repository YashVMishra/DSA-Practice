//https://leetcode.com/problems/fibonacci-number/description/?envType=study-plan&id=level-1

import java.util.Arrays;

public class Fibonacci_Number {
    public static void main(String[] args) {
        System.out.println(fib_1(4));
        System.out.println(fib_2(4));
        System.out.println(fib_3(4));
    }

    // using loop.
    public static int fib_1(int n) {
        int first = 0;
        int second = 1;
        int sum = 0;

        if (n == 1) {
            return 1;
        }

        for (int i = 0; i <= n - 2; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }

        return sum;
    }

    // using recursion.
    public static int fib_2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib_2(n - 1) + fib_2(n - 2);
    }

    // using DP.
    public static int fib_3(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    // helper function for DP solution.
    public static int helper(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);

        return dp[n];
    }
}
