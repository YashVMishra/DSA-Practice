// https://leetcode.com/problems/frog-jump/description/

import java.util.Arrays;
import java.util.HashMap;

public class Frog_Jump {
    static HashMap<Integer, Integer> mark = new HashMap<>();
    static int dp[][] = new int[2001][2001];

    public static void main(String[] args) {
        int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
        System.out.println(canCross(stones));
    }

    public static boolean canCross(int[] stones) {
        // Mark stones in the map to identify if such stone exists or not.
        for (int i = 0; i < stones.length; i++) {
            mark.put(stones[i], i);
        }

        // Mark all states as -1 to denote they're not calculated.
        for (int i = 0; i < 2000; i++) {
            Arrays.fill(dp[i], -1);
        }

        // return solve(stones, stones.length, 0, 0);
        return solve_DP(stones, stones.length, 0, 0);
    }

    // recursion
    private static boolean solve(int[] stones, int n, int index, int prevJump) {
        // If reached the last stone, return 1.
        if (index == n - 1) {
            return true;
        }

        boolean ans = false;
        // Iterate over the three possibilities {k - 1, k, k + 1}.
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0 && mark.containsKey(stones[index] + nextJump)) {
                ans = ans || solve(stones, n, mark.get(stones[index] + nextJump), nextJump);
            }
        }

        // Store the result to fetch later.
        return ans;
    }

    // DP.
    private static boolean solve_DP(int[] stones, int n, int index, int prevJump) {
        // If reached the last stone, return 1.
        if (index == n - 1) {
            return true;
        }

        // If this subproblem has already been calculated, return it.
        if (dp[index][prevJump] != -1) {
            return dp[index][prevJump] == 1;
        }

        boolean ans = false;
        // Iterate over the three possibilities {k - 1, k, k + 1}.
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0 && mark.containsKey(stones[index] + nextJump)) {
                ans = ans || solve_DP(stones, n, mark.get(stones[index] + nextJump), nextJump);
            }
        }

        // Store the result to fetch later.
        dp[index][prevJump] = (ans ? 1 : 0);
        return ans;
    }

}
