// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        System.out.println(maxProfit(prices, 2));
    }

    public static int maxProfit(int[] prices, int fee) {
        int[][] memo = new int[prices.length][2];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        // return solve(prices, 0, true);
        return solve_DP(prices, fee, 0, 1, memo);
    }

    // using recusion.
    // you can subtract the fee in either on buying or on selling.
    // both will produce same result.
    private static int solve(int[] prices, int fee, int index, boolean canBuy) {
        if (index >= prices.length) {
            return 0;
        }

        int profit = 0;
        if (canBuy) {
            int buy = solve(prices, fee, index + 1, false) - prices[index] - fee;
            int notBuy = solve(prices, fee, index + 1, true);

            profit = Math.max(profit, Math.max(buy, notBuy));
        } else {
            int sell = prices[index] + solve(prices, fee, index + 1, true);
            int notSell = solve(prices, fee, index + 1, false);

            profit = Math.max(profit, Math.max(sell, notSell));
        }

        return profit;
    }

    // using DP
    // here in this we have map canBuy to 0 and 1.
    // 0 means we can't buy and 1 means we can buy.
    // this is done for the memoization to be easy.
    private static int solve_DP(int[] prices, int fee, int index, int canBuy, int[][] memo) {
        if (index >= prices.length) {
            return 0;
        }

        if (memo[index][canBuy] != -1) {
            return memo[index][canBuy];
        }

        int profit = 0;
        if (canBuy == 1) {
            int buy = solve_DP(prices, fee, index + 1, 0, memo) - prices[index];
            int notBuy = solve_DP(prices, fee, index + 1, 1, memo);

            profit = Math.max(profit, Math.max(buy, notBuy));
        } else {
            int sell = prices[index] + solve_DP(prices, fee, index + 1, 1, memo) - fee;
            int notSell = solve_DP(prices, fee, index + 1, 0, memo);

            profit = Math.max(profit, Math.max(sell, notSell));
        }

        memo[index][canBuy] = profit;
        return profit;
    }
}
