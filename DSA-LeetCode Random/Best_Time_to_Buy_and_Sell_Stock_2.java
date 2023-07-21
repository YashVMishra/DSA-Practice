//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_2 {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int prev = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];

            if (prev < current) {
                profit += current - prev;
                prev = current;
            } else {
                prev = current;
            }
        }

        return profit;
    }
}
