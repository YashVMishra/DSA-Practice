//https://leetcode.com/problems/coin-change/description/

import java.util.Arrays;

public class Coins_Change {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        System.out.println(coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
