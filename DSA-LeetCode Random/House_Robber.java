// https://leetcode.com/problems/house-robber/description/?envType=daily-question&envId=2024-01-21

import java.util.Arrays;

public class House_Robber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        System.out.println(rob(arr));
    }

    public static int rob(int[] arr) {
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return solve_DP(arr, 0, memo);
    }

    public static int solve(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        int ans = 0;
        int take = arr[index] + solve(arr, index + 2);
        int notTake = 0 + solve(arr, index + 1);

        ans = Math.max(take, notTake);
        return ans;
    }

    public static int solve_DP(int[] arr, int index, int[] memo) {
        if (index >= arr.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int take = arr[index] + solve_DP(arr, index + 2, memo);
        int notTake = 0 + solve_DP(arr, index + 1, memo);

        memo[index] = Math.max(take, notTake);

        return memo[index];
    }
}
