//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        System.out.println(maxProfit(prices, 2));
    }

    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return helper(0, 1, prices, dp, fee);
    }

    public static int helper(int index, int buy, int[] prices, int[][] dp, int fee) {
        if (index == prices.length) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[index] - fee + helper(index + 1, 0, prices, dp, fee),
                    0 + helper(index + 1, 1, prices, dp, fee));
        } else {
            profit = Math.max(prices[index] + helper(index + 1, 1, prices, dp, fee),
                    0 + helper(index + 1, 0, prices, dp, fee));
        }

        dp[index][buy] = profit;
        return dp[index][buy];
    }
}
