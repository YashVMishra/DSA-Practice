//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

import java.util.Arrays;

public class Minimum_Cost_to_Cut_a_Stick {
    public static void main(String[] args) {
        int n = 7;
        int[] cuts = { 1, 3, 4, 5 };
        System.out.println(minCost(n, cuts));
    }

    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] dp = new int[101][101];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solve_DP(0, n, cuts, 0, cuts.length - 1, dp);
    }

    public static int solve(int start_stick, int end_stick, int[] cuts, int left, int right) {
        if (left > right) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int left_cost = solve(start_stick, cuts[i], cuts, left, i - 1);
            int right_cost = solve(cuts[i], end_stick, cuts, i + 1, right);
            int curr_cost = (end_stick - start_stick) + left_cost + right_cost;
            cost = Math.min(cost, curr_cost);
        }

        return cost;
    }

    public static int solve_DP(int start_stick, int end_stick, int[] cuts, int left, int right, int[][] dp) {
        if (left > right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int cost = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int left_cost = solve_DP(start_stick, cuts[i], cuts, left, i - 1, dp);
            int right_cost = solve_DP(cuts[i], end_stick, cuts, i + 1, right, dp);
            int curr_cost = (end_stick - start_stick) + left_cost + right_cost;
            cost = Math.min(cost, curr_cost);
        }

        return dp[left][right] = cost;
    }
}
