// https://leetcode.com/problems/painting-the-walls/description/?envType=daily-question&envId=2023-10-14

import java.util.Arrays;

public class Painting_the_Walls {
    public static void main(String[] args) {
        int[] cost = { 2, 3, 4, 2 };
        int[] time = { 1, 1, 1, 1 };

        System.out.println(paintWalls(cost, time));
    }

    public static int paintWalls(int[] cost, int[] time) {
        // return solve(cost, time, 0, cost.length - 1);
        int[][] memo = new int[cost.length + 1][cost.length + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve_DP(cost, time, 0, cost.length, memo);
    }

    // using recursion.
    private static int solve(int[] cost, int[] time, int index, int totalDays) {
        if (totalDays <= 0) {
            return 0;
        }

        if (index >= cost.length) {
            return 1000000000;
        }

        int ans = 0;
        int take = cost[index] + solve(cost, time, index + 1, totalDays - 1 - time[index]);
        int notTake = solve(cost, time, index + 1, totalDays);

        ans = Math.min(take, notTake);
        return ans;
    }

    // using DP
    private static int solve_DP(int[] cost, int[] time, int index, int totalDays, int[][] memo) {
        if (totalDays <= 0) {
            return 0;
        }

        if (index >= cost.length) {
            return 1000000000;
        }

        if (memo[index][totalDays] != -1) {
            return memo[index][totalDays];
        }

        int ans = 0;
        int take = cost[index] + solve_DP(cost, time, index + 1, totalDays - 1 - time[index], memo);
        int notTake = solve_DP(cost, time, index + 1, totalDays, memo);

        ans = Math.min(take, notTake);
        memo[index][totalDays] = ans;
        return ans;
    }
}
