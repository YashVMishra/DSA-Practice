//https://leetcode.com/problems/reducing-dishes/description/

import java.util.Arrays;

public class Reducing_Dishes {
    public static void main(String[] args) {
        int[] satisfaction = { 4, 3, 2 };
        System.out.println(maxSatisfaction(satisfaction));
    }

    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        // return solve(satisfaction, 0, 1);

        // int[][] dp = new int[satisfaction.length + 1][satisfaction.length + 1];
        // for (int[] arr : dp) {
        // Arrays.fill(arr, -1);
        // }

        // return solveMemo(satisfaction, 0, 1, dp);

        return solveTab(satisfaction);

    }

    // method using recursion.
    public static int solve(int[] satisfaction, int index, int time) {

        // base case.
        if (index == satisfaction.length) {
            return 0;
        }

        int include = (satisfaction[index] * (time)) + solve(satisfaction, index + 1, time + 1);
        int exclude = 0 + solve(satisfaction, index + 1, time);

        return Math.max(include, exclude);
    }

    // using memoization.
    public static int solveMemo(int[] satisfaction, int index, int time, int[][] dp) {

        // base case.
        if (index == satisfaction.length) {
            return 0;
        }

        if (dp[index][time] != -1) {
            return dp[index][time];
        }

        int include = (satisfaction[index] * (time)) + solveMemo(satisfaction, index + 1, time + 1, dp);
        int exclude = 0 + solveMemo(satisfaction, index + 1, time, dp);

        return dp[index][time] = Math.max(include, exclude);
    }

    // using tabulation.
    public static int solveTab(int[] satisfaction) {
        int n = satisfaction.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int time = index; time >= 0; time--) {

                int include = (satisfaction[index] * (time + 1)) + dp[index + 1][time + 1];
                int exclude = 0 + dp[index + 1][time];

                dp[index][time] = Math.max(include, exclude);
            }
        }

        return dp[0][0];
    }
}
