//https://leetcode.com/problems/profitable-schemes/description/

import java.util.Arrays;

public class Profitable_Schemes {
    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        int n = 5;
        int minProfit = 3;
        int[] group = { 2, 2 };
        int[] profit = { 2, 3 };
        System.out.println(profitableSchemes(n, minProfit, group, profit));
    }

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // return solve1(0, 0, 0, n, minProfit, group, profit);
        int[][][] dp = new int[102][102][102];

        for (int[][] arr1 : dp) {
            for (int[] arr2 : arr1) {
                Arrays.fill(arr2, -1);
            }
        }

        return solve2(0, 0, 0, n, minProfit, group, profit, dp);
    }

    // using recursion.
    public static int solve1(int k, int i, int j, int n, int minProfit, int[] group, int[] profit) {
        if (k == profit.length) {
            if (j >= minProfit && n >= i) {
                return 1;
            }

            else {
                return 0;
            }
        }

        else if (n < i) {
            return 0;
        }

        int include = 0;
        int notInclude = 0;

        notInclude = solve1(k + 1, i, j, n, minProfit, group, profit);
        include = solve1(k + 1, i + group[k], Math.min(j + profit[k], minProfit), n, minProfit, group, profit);

        return (include % mod + notInclude % mod) % mod;
    }

    // using dp
    public static int solve2(int k, int i, int j, int n, int minProfit, int[] group, int[] profit, int[][][] dp) {
        if (k == profit.length) {
            if (j >= minProfit && n >= i) {
                return 1;
            }

            else {
                return 0;
            }
        }

        else if (n < i) {
            return 0;
        }

        if (dp[k][i][j] != -1) {
            return dp[k][i][j];
        }

        int include = 0;
        int notInclude = 0;

        notInclude = solve2(k + 1, i, j, n, minProfit, group, profit, dp);
        include = solve2(k + 1, i + group[k], Math.min(j + profit[k], minProfit), n, minProfit, group, profit, dp);

        dp[k][i][j] = (include % mod + notInclude % mod) % mod;
        return dp[k][i][j];
    }
}
