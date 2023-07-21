//https://leetcode.com/problems/set-matrix-zeroes/

import java.util.Arrays;

public class Set_Matrix_Zero {
    public static void main(String[] args) {
        int[][] nums = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        int[][] nums_2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroes(nums);
        setZeroes_2(nums_2);

        System.out.println(Arrays.deepToString(nums));
        System.out.println(Arrays.deepToString(nums_2));
    }

    // using extra space.
    public static void setZeroes(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;

        int[] row_arr = new int[row];
        for (int i = 0; i < row; i++) {
            row_arr[i] = -1;
        }

        int[] col_arr = new int[col];
        for (int i = 0; i < col; i++) {
            col_arr[i] = -1;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] == 0) {
                    row_arr[i] = 0;
                    col_arr[j] = 0;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            if (row_arr[i] == 0) {
                for (int j = 0; j < col; j++) {
                    nums[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < col; i++) {
            if (col_arr[i] == 0) {
                for (int j = 0; j < row; j++) {
                    nums[j][i] = 0;
                }
            }
        }

        // System.out.println(Arrays.toString(row_arr));
        // System.out.println(Arrays.toString(col_arr));
    }

    // without using extra space
    public static void setZeroes_2(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] == 0) {
                    nums[0][j] = 0;
                    nums[i][0] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(nums));

        for (int i = 0; i < col; i++) {
            if (nums[0][i] == 0) {
                for (int j = 0; j < row; j++) {
                    nums[j][i] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(nums));

        for (int i = 1; i < row - 1; i++) {
            if (nums[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    nums[i][j] = 0;
                }
            }
        }
    }
}
