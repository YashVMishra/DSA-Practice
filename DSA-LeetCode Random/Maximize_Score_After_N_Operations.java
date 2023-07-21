//https://leetcode.com/problems/maximize-score-after-n-operations/description/

import java.util.Arrays;

public class Maximize_Score_After_N_Operations {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 6, 8 };
        System.out.println(maxScore(nums));
    }

    public static int maxScore(int[] nums) {
        // return dfs(0, 0, nums);
        int dpSize = (1 << nums.length);
        int[] dp = new int[dpSize];
        Arrays.fill(dp, -1);
        return dfs_DP(0, 0, nums, dp);
    }

    // using recursion
    // hsows TLE.
    public static int dfs(int mask, int operation, int[] nums) {
        if (2 * operation == nums.length) {
            return 0;
        }

        int maxScore = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (((mask >> i) & 1) == 1 || ((mask >> j) & 1) == 1) {
                    continue;
                }

                int newMask = mask | (1 << i) | (1 << j);
                int currScore = (operation + 1) * gcd(nums[i], nums[j]);
                int remainingScore = dfs(newMask, operation + 1, nums);

                maxScore = Math.max(maxScore, currScore + remainingScore);
            }
        }

        return maxScore;
    }

    // using DP.
    // for the solution read the editorial of the ques along with the
    // video provided in OneNote.
    public static int dfs_DP(int mask, int operation, int[] nums, int[] dp) {
        if (2 * operation == nums.length) {
            return 0;
        }

        if (dp[mask] != -1) {
            return dp[mask];
        }

        int maxScore = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (((mask >> i) & 1) == 1 || ((mask >> j) & 1) == 1) {
                    continue;
                }

                int newMask = mask | (1 << i) | (1 << j);
                int currScore = (operation + 1) * gcd(nums[i], nums[j]);
                int remainingScore = dfs_DP(newMask, operation + 1, nums, dp);

                maxScore = Math.max(maxScore, currScore + remainingScore);
            }
        }

        dp[mask] = maxScore;
        return dp[mask];
    }

    // Utility function to calculate the gcd of two numbers.
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
