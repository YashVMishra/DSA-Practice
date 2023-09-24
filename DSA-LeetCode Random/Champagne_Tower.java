// https://leetcode.com/problems/champagne-tower/description/?envType=daily-question&envId=2023-09-24

import java.util.Arrays;

public class Champagne_Tower {
    public static void main(String[] args) {
        System.out.println(champagneTower(100000009, 33, 17));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] memo = new double[query_row + 1][query_row + 1];
        for (double[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return Math.min(1.0, helper_DP(poured, query_row, query_glass, memo));
    }

    // recursion.
    private static double helper(int poured, int i, int j) {
        if (i < 0 || j < 0 || j > i) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return poured;
        }

        double leftUp = (helper(poured, i - 1, j - 1) - 1) / 2.0;
        double rightUp = (helper(poured, i - 1, j) - 1) / 2.0;

        if (leftUp < 0) {
            leftUp = 0;
        }

        if (rightUp < 0) {
            rightUp = 0;
        }

        return leftUp + rightUp;
    }

    // DP
    private static double helper_DP(int poured, int i, int j, double[][] memo) {
        if (i < 0 || j < 0 || j > i) {
            return 0.0;
        }

        if (i == 0 && j == 0) {
            return memo[i][j] = poured;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        double leftUp = (helper_DP(poured, i - 1, j - 1, memo) - 1) / 2.0;
        double rightUp = (helper_DP(poured, i - 1, j, memo) - 1) / 2.0;

        if (leftUp < 0) {
            leftUp = 0.0;
        }

        if (rightUp < 0) {
            rightUp = 0.0;
        }

        return memo[i][j] = leftUp + rightUp;
    }
}
