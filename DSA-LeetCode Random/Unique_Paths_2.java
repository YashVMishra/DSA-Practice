// https://leetcode.com/problems/unique-paths-ii/description/

import java.util.Arrays;

public class Unique_Paths_2 {
    static int ans = 0;

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return helper(0, 0, obstacleGrid, dp);
    }

    // recursion.
    public static int helper(int row, int col, int[][] obstacleGrid) {
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            if (obstacleGrid[row][col] != 1) {
                return 1;
            }

            return 0;
        }

        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        int right = 0;
        int down = 0;

        if (row < obstacleGrid.length - 1) {
            down += helper(row + 1, col, obstacleGrid);
        }

        if (col < obstacleGrid[0].length - 1) {
            right += helper(row, col + 1, obstacleGrid);
        }

        return down + right;
    }

    // DP used.
    public static int helper(int row, int col, int[][] obstacleGrid, int[][] dp) {
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            if (obstacleGrid[row][col] != 1) {
                return 1;
            }

            return 0;
        }

        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int right = 0;
        int down = 0;

        if (row < obstacleGrid.length - 1) {
            down += helper(row + 1, col, obstacleGrid, dp);
        }

        if (col < obstacleGrid[0].length - 1) {
            right += helper(row, col + 1, obstacleGrid, dp);
        }

        return dp[row][col] = down + right;
    }
}
