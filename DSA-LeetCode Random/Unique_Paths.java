//https://leetcode.com/problems/unique-paths/description/

import java.util.Arrays;

public class Unique_Paths {
    public static void main(String[] args) {
        int row = 3;
        int col = 2;
        int[][] dp = new int[row][col];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // we have to taken row+1 and col+1 because we are starting from the last cell.
        // and the first call for dp[m][n] will be dp[3][2] so we have wriiten +1.
        int[][] memo = new int[row + 1][col + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths_DP_1(3, 2, memo));
        System.out.println(uniquePaths_DP_2(3, 2, dp, 0, 0));
    }

    // for this see KK video of Maze Problems.
    // this method shows TLE.
    // Ques says down and right but since we are starting from
    // the last cell so we have to go up and left.
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int up = uniquePaths(m - 1, n);
        int left = uniquePaths(m, n - 1);

        return up + left;
    }

    // --------------------------------------------------------------------------------------

    // apply memoization to the above method.
    public static int uniquePaths_DP_1(int m, int n, int[][] dp) {
        if (m == 1 || n == 1) {
            return 1;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int up = uniquePaths_DP_1(m - 1, n, dp);
        int left = uniquePaths_DP_1(m, n - 1, dp);

        return dp[m][n] = up + left;
    }

    // --------------------------------------------------------------------------------------

    // new recursive method.
    // in this we will do down and right as we are starting from
    // the first cell.
    public static int uniquePaths_DP_2(int row, int col, int[][] dp, int i, int j) {
        if (i == row - 1 || j == col - 1) {
            return 1;
        }

        if (i >= row || j >= col) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = uniquePaths_DP_2(row, col, dp, i + 1, j);
        int right = uniquePaths_DP_2(row, col, dp, i, j + 1);

        return dp[i][j] = down + right;
    }
}
