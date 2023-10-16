// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/?envType=daily-question&envId=2023-10-15Pascal's Triangle II

import java.util.Arrays;

public class Number_of_Ways_to_Stay_in_the_Same_Place_After_Some_Steps {
    static int mod = 1000000007;
    private static int[][] memo;
    private static int n;

    public static void main(String[] args) {
        System.out.println(numWays(27, 7));
    }

    public static int numWays(int steps, int arrLen) {
        // return solve(steps, arrLen, 0);
        arrLen = Math.min(arrLen, steps);
        n = arrLen;
        memo = new int[501][501];
        for (int i = 0; i < 501; i++) {
            Arrays.fill(memo[i], -1);
        }

        return solve_DP(0, steps);
    }

    // using recursion.
    private static int solve(int index, int steps) {
        if (index < 0 || index >= n) {
            return 0;
        }

        if (steps == 0) {
            if (index == 0) {
                return 1;
            }

            return 0;
        }

        int result = solve_DP(index + 1, steps - 1) % mod; // RIGHT
        result = (result + solve_DP(index - 1, steps - 1)) % mod; // LEFT
        result = (result + solve_DP(index, steps - 1)) % mod; // STAY

        return result;
    }

    // using DP
    private static int solve_DP(int index, int steps) {
        if (index < 0 || index >= n) {
            return 0;
        }

        if (steps == 0) {
            return index == 0 ? 1 : 0;
        }

        if (memo[index][steps] != -1) {
            return memo[index][steps];
        }

        int result = solve_DP(index + 1, steps - 1) % mod; // RIGHT
        result = (result + solve_DP(index - 1, steps - 1)) % mod; // LEFT
        result = (result + solve_DP(index, steps - 1)) % mod; // STAY

        memo[index][steps] = result;
        return result;
    }
}
