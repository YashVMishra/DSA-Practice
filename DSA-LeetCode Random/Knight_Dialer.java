// https://leetcode.com/problems/knight-dialer/description/?envType=daily-question&envId=2023-11-27

import java.util.Arrays;
import java.util.List;

public class Knight_Dialer {

    private static final int M = 1000000007;
    private static final List<List<Integer>> adj = Arrays.asList(
            Arrays.asList(4, 6),
            Arrays.asList(6, 8),
            Arrays.asList(7, 9),
            Arrays.asList(4, 8),
            Arrays.asList(3, 9, 0),
            Arrays.asList(),
            Arrays.asList(1, 7, 0),
            Arrays.asList(2, 6),
            Arrays.asList(1, 3),
            Arrays.asList(2, 4));

    private static int[][] memo = new int[5001][10];

    public static void main(String[] args) {
        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3131));
    }

    public static int knightDialer(int n) {
        int result = 0;
        for (int[] memoRow : memo) {
            Arrays.fill(memoRow, -1);
        }

        for (int cell = 0; cell <= 9; cell++) {
            result = (result + solve_DP(n - 1, cell)) % M;
        }

        return result;
    }

    // using recursion.
    // shows TLE.
    private static int solve(int n, int cell) {
        if (n == 0) {
            return 1;
        }

        int result = 0;
        for (int nextCell : adj.get(cell)) {
            result = (result + solve(n - 1, nextCell)) % M;
        }

        return result;
    }

    // using memoization.
    private static int solve_DP(int n, int cell) {
        if (n == 0) {
            return 1;
        }

        if (memo[n][cell] != -1) {
            return memo[n][cell];
        }

        int result = 0;

        for (int nextCell : adj.get(cell)) {
            result = (result + solve_DP(n - 1, nextCell)) % M;
        }

        return memo[n][cell] = result;
    }
}
