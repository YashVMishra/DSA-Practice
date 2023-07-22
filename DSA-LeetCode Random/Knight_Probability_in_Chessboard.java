// https://leetcode.com/problems/knight-probability-in-chessboard/

import java.util.Arrays;

public class Knight_Probability_in_Chessboard {
    static int[][] dir = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 } };

    public static void main(String[] args) {
        int n = 3, k = 2, row = 0, column = 0;
        System.out.println(knightProbability(n, k, row, column));
    }

    public static double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (double[][] i : dp) {
            for (double[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        return findProb_DP(n, k, row, column, dp);
    }

    public double findProb(int len, int moves, int row, int col) {
        if (row < 0 || row >= len || col < 0 || col >= len) {
            return 0;
        }

        if (moves == 0) {
            return 1;
        }

        double probability = 0;
        for (int i = 0; i < 8; i++) {
            probability += findProb(len, moves - 1, row + dir[i][0], col + dir[i][1]) / 8;
        }

        return probability;
    }

    public static double findProb_DP(int len, int moves, int row, int col, double[][][] dp) {
        if (row < 0 || row >= len || col < 0 || col >= len) {
            return 0;
        }

        if (moves == 0) {
            return 1;
        }

        if (dp[moves][row][col] != -1) {
            return dp[moves][row][col];
        }

        double probability = 0;
        for (int i = 0; i < 8; i++) {
            probability += findProb_DP(len, moves - 1, row + dir[i][0], col + dir[i][1], dp) / 8;
        }

        dp[moves][row][col] = probability;
        return probability;
    }
}
