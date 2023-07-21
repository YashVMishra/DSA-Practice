//https://leetcode.com/problems/stone-game-iii/description/

import java.util.Arrays;

public class Stone_Game_3 {
    public static void main(String[] args) {
        int[] stoneValue = { 1, 2, 3, 7 };
        System.out.println(stoneGameIII(stoneValue));
    }

    public static String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp, -1);
        int value = stoneGame_DP(stoneValue, 0, dp);

        if (value > 0) {
            return "Alice";
        }

        else if (value < 0) {
            return "Bob";
        }

        else {
            return "Tie";
        }
    }

    public static int stoneGame(int[] stoneValue, int index) {
        if (index >= stoneValue.length) {
            return 0;
        }

        int takeOne = stoneValue[index] - stoneGame(stoneValue, index + 1);

        int takeTwo = Integer.MIN_VALUE;
        if (index + 1 < stoneValue.length) {
            takeTwo = stoneValue[index] + stoneValue[index + 1] - stoneGame(stoneValue, index + 2);
        }

        int takeThree = Integer.MIN_VALUE;
        if (index + 2 < stoneValue.length) {
            takeThree = stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2]
                    - stoneGame(stoneValue, index + 3);
        }

        return Math.max(takeOne, Math.max(takeTwo, takeThree));
    }

    public static int stoneGame_DP(int[] stoneValue, int index, int[] dp) {
        if (index >= stoneValue.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int takeOne = stoneValue[index] - stoneGame_DP(stoneValue, index + 1, dp);

        int takeTwo = Integer.MIN_VALUE;
        if (index + 1 < stoneValue.length) {
            takeTwo = stoneValue[index] + stoneValue[index + 1] - stoneGame_DP(stoneValue, index + 2, dp);
        }

        int takeThree = Integer.MIN_VALUE;
        if (index + 2 < stoneValue.length) {
            takeThree = stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2]
                    - stoneGame_DP(stoneValue, index + 3, dp);
        }

        dp[index] = Math.max(takeOne, Math.max(takeTwo, takeThree));
        return dp[index];
    }
}
