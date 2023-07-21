//https://leetcode.com/problems/stone-game-ii/description/

public class Stone_Game_2 {
    public static void main(String[] args) {
        int[] piles = { 2, 7, 9, 4, 4 };
        System.out.println(stoneGameII(piles));
    }

    public static int stoneGameII(int[] piles) {
        if (piles.length == 0) {
            return 0;
        }

        int[] suffixSum = new int[piles.length];
        suffixSum[suffixSum.length - 1] = piles[piles.length - 1];

        for (int i = piles.length - 2; i >= 0; --i) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }

        return helper(piles, suffixSum, 0, 1);
    }

    public static int helper(int[] piles, int[] suffixSum, int i, int M) {
        if (i == piles.length) {
            return 0;
        }

        if (i + 2 * M >= piles.length) {
            return suffixSum[i];
        }

        int result = 0;
        for (int x = 1; x <= 2 * M; ++x) {
            result = Math.max(result, suffixSum[i] - helper(piles, suffixSum, i + x, Math.max(M, x)));
        }

        return result;
    }

    public static int helper_DP(int[] piles, int[][] dp, int[] suffixSum, int i, int M) {
        if (i == piles.length) {
            return 0;
        }

        if (i + 2 * M >= piles.length) {
            return suffixSum[i];
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int result = 0;
        for (int x = 1; x <= 2 * M; ++x) {
            result = Math.max(result, suffixSum[i] - helper_DP(piles, dp, suffixSum, i + x, Math.max(M, x)));
        }

        dp[i][M] = result;
        return result;
    }
}
