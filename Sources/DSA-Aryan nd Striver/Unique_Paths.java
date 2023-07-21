//https://leetcode.com/problems/unique-paths/description/

import java.util.Arrays;

public class Unique_Paths {
    public static void main(String[] args) {
        int row = 3;
        int col = 7;
        System.out.println(uniquePaths(row, col));
    }

    public static int uniquePaths(int row, int col) {
        int[][] dp = new int[row][col];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return numberOfPaths_2(row, col, 0, 0, dp);
    }

    // uses recursion.
    public static int numberOfPaths(int row, int col, int i, int j) {
        if (i == row - 1 && j == col - 1) {
            return 1;
        }

        if (i >= row || j >= col) {
            return 0;
        }

        return numberOfPaths(row, col, i + 1, j) + numberOfPaths(row, col, i, j + 1);
    }

    // uses recursion.
    public static int numberOfPaths_2(int row, int col, int i, int j, int[][] dp) {
        if (i == row - 1 && j == col - 1) {
            return 1;
        }

        if (i >= row || j >= col) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = numberOfPaths_2(row, col, i + 1, j, dp) + numberOfPaths_2(row, col, i, j + 1, dp);
        return dp[i][j];
    }
}
