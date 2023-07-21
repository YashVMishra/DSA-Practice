//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] arr = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minCost = prices[0];

        for (int i = 0; i < prices.length; i++) {
            minCost = Math.min(minCost, prices[i]);

            int profit = prices[i] - minCost;

            maxProfit = Math.max(maxProfit, profit);

        }

        return maxProfit;
    }
}
