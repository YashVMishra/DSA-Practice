//https://leetcode.com/problems/buy-two-chocolates/

import java.util.Arrays;

public class Buy_Two_Chocolates {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 2 };
        int money = 3;
        System.out.println(buyChoco(prices, money));
    }

    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        if (money - (prices[0] + prices[1]) >= 0) {
            return money - (prices[0] + prices[1]);
        }

        else {
            return money;
        }
    }
}
