//https://leetcode.com/problems/unique-paths/description/

import java.util.Arrays;

public class Unique_Paths {
    public static void main(String[] args) {
        int row = 3;
        int col = 7;
        int[][] dp = new int[row][col];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths_2(3, 7, dp, 0, 0));
    }

    // for this see KK video of Maze Problems.
    // this method shows TLE.
    public static int uniquePaths(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        int down = uniquePaths(row - 1, col);
        int right = uniquePaths(row, col - 1);

        return down + right;
    }

    // this method uses DP
    public static int uniquePaths_2(int row, int col, int[][] dp, int i, int j) {

        if (i == row - 1 && j == col - 1) {
            return 1;
        }

        if (i >= row || j >= col) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        else {
            return dp[i][j] = uniquePaths_2(row, col, dp, i + 1, j) + uniquePaths_2(row, col, dp, i, j + 1);
        }
    }

}
