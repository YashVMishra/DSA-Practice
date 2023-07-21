//https://leetcode.com/problems/spiral-matrix-ii/description/

import java.util.Arrays;

public class Spiral_Matrix_2 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int value = 1;

        int row_start = 0;
        int row_end = n - 1;
        int col_start = 0;
        int col_end = n - 1;

        while (row_start <= row_end && col_start <= col_end && value <= (n * n)) {

            // right
            for (int i = col_start; i <= col_end; i++) {
                ans[row_start][i] = value;
                value++;
            }

            row_start++;

            // down
            for (int i = row_start; i <= row_end; i++) {
                ans[i][col_end] = value;
                value++;
            }

            col_end--;

            // left
            if (row_start <= row_end) {
                for (int i = col_end; i >= col_start; i--) {
                    ans[row_end][i] = value;
                    value++;
                }

                row_end--;
            }

            // top
            if (row_start <= row_end) {
                for (int i = row_end; i >= row_start; i--) {
                    ans[i][col_start] = value;
                    value++;
                }

                col_start++;
            }
        }

        return ans;
    }
}
