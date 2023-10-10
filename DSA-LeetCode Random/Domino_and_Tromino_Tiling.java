// https://leetcode.com/problems/domino-and-tromino-tiling/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class Domino_and_Tromino_Tiling {
    static int mod = 1000000007;

    public static void main(String[] args) {
        System.out.println(numTilings(4));
    }

    public static int numTilings(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve_DP(n, memo);
    }

    private static int solve(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (n == 3) {
            return 5;
        }

        return (2 * solve(n - 1) % mod + solve(n - 3) % mod) % mod;
    }

    private static int solve_DP(int n, int[] memo) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (n == 3) {
            return 5;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = (2 * solve_DP(n - 1, memo) % mod + solve_DP(n - 3, memo) % mod) % mod;
        return memo[n];
    }
}
