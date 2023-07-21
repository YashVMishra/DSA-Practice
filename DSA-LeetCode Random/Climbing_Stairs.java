//https://leetcode.com/problems/climbing-stairs/description/

import java.util.Arrays;

public class Climbing_Stairs {
    public static void main(String[] args) {
        System.out.println(climbStairs_1(5));
        System.out.println(climbStairs_2(5));
    }

    public static int climbStairs_1(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs_1(n - 1) + climbStairs_1(n - 2);

    }

    public static int climbStairs_2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return compute(n, dp);

    }

    // RR similar to fibonacci number.
    public static int compute(int n, int[] dp) {
        if (n <= 2) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = compute(n - 1, dp) + compute(n - 2, dp);

        return dp[n];
    }
}
