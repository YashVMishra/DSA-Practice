//https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan&id=level-1

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        // return Math.min(helper(cost, 0), helper(cost, 1));
        int[] dp = new int[cost.length];

        // for this logic see the hint in the given question.
        // The answer will be the minimum of dp[0] and dp[1].
        Arrays.fill(dp, -1);
        helper_2(cost, 0, dp);
        return Math.min(dp[0], dp[1]);
    }

    // using recursion.
    public static int helper_1(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }

        int ans = 0;
        ans = Math.min((cost[i] + helper_1(cost, i + 1)), (cost[i] + helper_1(cost, i + 2)));

        return ans;
    }

    // using DP
    public static int helper_2(int[] cost, int i, int[] dp) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = 0;
        ans = Math.min((cost[i] + helper_2(cost, i + 1, dp)), (cost[i] + helper_2(cost, i + 2, dp)));
        dp[i] = ans;

        return dp[i];
    }
}
