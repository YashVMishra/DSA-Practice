// https://leetcode.com/problems/minimum-falling-path-sum/description/?envType=daily-question&envId=2024-01-19

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };

        System.out.println(minFallingPathSum(matrix));
    }

    // this will show TLE as new test cases has been added.
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length; // row
        int n = m; // column

        int[][] t = new int[101][101];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        int result = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            result = Math.min(result, MFS(matrix, 0, col, t));
        }

        return result;
    }

    private static int MFS(int[][] matrix, int row, int col, int[][] t) {
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }

        if (t[row][col] != -1) {
            return t[row][col];
        }

        int minSum = Integer.MAX_VALUE;
        for (int shift = -1; shift <= 1; shift++) {
            if (col + shift >= 0 && col + shift < matrix[row].length) {
                minSum = Math.min(minSum, matrix[row][col] + MFS(matrix, row + 1, col + shift, t));
            }
        }

        return t[row][col] = minSum;
    }

    // --------------------------------------------------------------------------------------

    public static int minFallingPathSum_2(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];

        // Initialize the first row of prev array
        for (int col = 0; col < n; col++) {
            prev[col] = matrix[0][col];
        }

        // Iterate over the remaining rows
        for (int row = 1; row < n; row++) {
            int[] curr = new int[n];
            for (int col = 0; col < n; col++) {
                curr[col] = matrix[row][col]
                        + Math.min(Math.min(prev[Math.max(0, col - 1)], prev[col]), prev[Math.min(n - 1, col + 1)]);
            }
            prev = curr;
        }

        // Return the minimum element in the last row of the dp array
        int minPathSum = Integer.MAX_VALUE;
        for (int value : prev) {
            minPathSum = Math.min(minPathSum, value);
        }

        return minPathSum;
    }
}
