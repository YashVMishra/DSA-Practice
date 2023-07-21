//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/s

public class Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_cost = prices[0];

        for (int i = 0; i < prices.length; i++) {
            min_cost = Math.min(min_cost, prices[i]);

            int profit = prices[i] - min_cost;

            max_profit = Math.max(profit, max_profit);
        }

        return max_profit;
    }

}
