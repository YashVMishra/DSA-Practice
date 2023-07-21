//https://leetcode.com/problems/spiral-matrix-ii/description/

import java.util.Arrays;

public class Spiral_Matrix_2 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int rowStart = 0;
        int colStart = 0;
        int colEnd = n - 1;
        int rowEnd = n - 1;
        int value = 1;

        while (rowStart <= rowEnd && colStart <= colEnd && value <= (n * n)) {

            // going from left to right
            for (int i = colStart; i <= colEnd; i++) {
                ans[rowStart][i] = value;
                value++;
            }

            rowStart++;

            // going from top to down
            for (int i = rowStart; i <= rowEnd; i++) {
                ans[i][colEnd] = value;
                value++;
            }

            colEnd--;

            // going from right to left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    ans[rowEnd][i] = value;
                    value++;
                }

                rowEnd--;
            }

            // going from down to top
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    ans[i][colStart] = value;
                    value++;
                }

                colStart++;
            }

        }

        return ans;
    }
}