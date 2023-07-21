//https://leetcode.com/problems/coin-change-ii/

public class Coins_Change_2 {
    public static void main(String[] args) {
        int[] coins = { 10 };
        System.out.println(diff_types(coins, 10));
    }

    public static int diff_types(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        // Fill 1st row with 0 because no amount (except 0) can be formed without any
        // coin
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = 0;
        }

        // assuming amount 0 can always be formed
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }

                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }
}
