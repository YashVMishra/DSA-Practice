//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minCost = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minCost = Math.min(prices[i], minCost);

            int currProfit = prices[i] - minCost;

            maxProfit = Math.max(currProfit, maxProfit);
        }

        return maxProfit;
    }
}
