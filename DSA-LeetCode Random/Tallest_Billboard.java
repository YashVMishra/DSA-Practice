//https://leetcode.com/problems/tallest-billboard/description/

import java.util.Arrays;

public class Tallest_Billboard {

    static final int MIN = -10000;
    static final int OFFSET = 5000;
    static int[][] dp;
    static int ans;

    public static void main(String[] args) {
        int[] rods = { 1, 2, 3, 4, 5, 6 };
        System.out.println(tallestBillboard(rods));
    }

    public static int tallestBillboard(int[] rods) {
        dp = new int[21][2 * OFFSET + 1];
        for (int i = 0; i < 21; i++) {
            Arrays.fill(dp[i], -1);
        }

        ans = solve_2(0, 0, rods);
        if (ans < 0) {
            return 0;
        } else {
            return ans;
        }
    }

    // using recursion.
    public static int solve(int i, int s1, int s2, int[] rods) {
        if (i == rods.length) {
            if (s1 == s2) {
                return s1;
            }

            return 0;
        }

        int ans = 0;

        int op1 = solve(i + 1, s1, s2, rods);
        int opt2 = solve(i + 1, s1 + rods[i], s2, rods);
        int opt3 = solve(i + 1, s1, s2 + rods[i], rods);

        ans = Math.max(op1, Math.max(opt2, opt3));
        return ans;
    }

    // using DP.
    public static int solve_2(int i, int diff, int[] rods) {
        if (i == rods.length) {
            if (diff == 0) {
                return 0;
            }
            return MIN;
        }

        if (dp[i][diff + OFFSET] != -1) {
            return dp[i][diff + OFFSET];
        }

        int opt1 = solve_2(i + 1, diff, rods);
        int opt2 = rods[i] + solve_2(i + 1, diff + rods[i], rods);
        int opt3 = solve_2(i + 1, diff - rods[i], rods);

        return dp[i][diff + OFFSET] = Math.max(Math.max(opt1, opt2), opt3);
    }
}
