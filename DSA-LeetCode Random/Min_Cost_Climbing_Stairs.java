// https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        helper_DP(cost, 0, memo);
        return Math.min(memo[0], memo[1]);
    }

    // using recursion
    public static int helper(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }

        int ans = 0;
        ans = cost[i] + Math.min(helper(cost, i + 1), helper(cost, i + 2));

        return ans;
    }

    // using DP
    public static int helper_DP(int[] cost, int index, int[] memo) {
        if (index >= cost.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int ans = 0;
        ans = cost[index] + Math.min(helper_DP(cost, index + 1, memo), helper_DP(cost, index + 2, memo));
        memo[index] = ans;

        return ans;
    }
}
