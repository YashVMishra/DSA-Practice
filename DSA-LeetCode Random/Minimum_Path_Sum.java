//https://leetcode.com/problems/minimum-path-sum/description/

import java.util.Arrays;

public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // return (sum(grid, grid.length - 1, grid[0].length - 1));

        return (sum_2(grid, grid.length - 1, grid[0].length - 1, dp));
    }

    public static int sum(int[][] grid, int row, int col) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }

        if (row < 0 || col < 0) {
            return (int) Math.pow(10, 9);
        }

        int up = grid[row][col] + sum(grid, row - 1, col);
        int left = grid[row][col] + sum(grid, row, col - 1);

        return Math.min(up, left);
    }

    public static int sum_2(int[][] grid, int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }

        if (row < 0 || col < 0) {
            return 101;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int up = grid[row][col] + sum_2(grid, row - 1, col, dp);
        int left = grid[row][col] + sum_2(grid, row, col - 1, dp);

        dp[row][col] = Math.min(up, left);

        return dp[row][col];
    }
}
