//https://leetcode.com/problems/set-matrix-zeroes/description/

import java.util.Arrays;

public class Set_Matrix_Zeroes {
    public static void main(String[] args) {
        int[][] nums = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        // setZeroes(nums);
        // setZeroes_2(nums);
        setZeroes_3(nums);
    }

    // using extra spacc of O(m * n)
    public static void setZeroes(int[][] nums) {
        int[][] ans = new int[nums.length][nums[0].length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                ans[i][j] = nums[i][j];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    set(ans, i, j);
                }
            }
        }

        nums = ans;

        System.out.println(Arrays.deepToString(nums));
    }

    public static void set(int[][] ans, int row, int col) {

        // setting the row as zero
        for (int i = 0; i < ans[0].length; i++) {
            ans[row][i] = 0;
        }

        // setting the col as zero
        for (int i = 0; i < ans.length; i++) {
            ans[i][col] = 0;
        }
    }

    // using extra spacc of O(m + n)
    public static void setZeroes_2(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;

        int[] rowArr = new int[row];
        int[] colArr = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] == 0) {
                    rowArr[i] = 1;
                    colArr[j] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowArr[i] == 1 || colArr[j] == 1) {
                    nums[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(nums));
    }

    public static void setZeroes_3(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;
        int firstRow = 1;
        int firstCol = 1;

        // finding whether the first row has 0 or not.
        for (int j = 0; j < col; j++) {
            if (nums[0][j] == 0) {
                firstRow = 0;
            }
        }

        // finding whether the first col has 0 or not.
        for (int i = 0; i < row; i++) {
            if (nums[i][0] == 0) {
                firstCol = 0;
            }
        }

        // making the first row and col as marker array we mark them
        // if the inner elements contain 0.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (nums[i][j] == 0) {
                    nums[i][0] = 0;
                    nums[0][j] = 0;
                }
            }
        }

        // now based on the marker row we make the corresponding
        // elements as 0.
        for (int j = 1; j < col; j++) {
            if (nums[0][j] == 0) {

                for (int i = 1; i < row; i++) {
                    nums[i][j] = 0;
                }
            }
        }

        // now based on the marker column we make the corresponding
        // elements as 0.
        for (int i = 1; i < row; i++) {
            if (nums[i][0] == 0) {

                for (int j = 1; j < col; j++) {
                    nums[i][j] = 0;
                }
            }
        }

        // if the first column contains 0 we make the entire col as 0.
        if (firstCol == 0) {
            for (int i = 0; i < row; i++) {
                nums[i][0] = 0;
            }
        }

        // if the first row contains 0 we make the entire row as 0.
        if (firstRow == 0) {
            for (int j = 0; j < col; j++) {
                nums[0][j] = 0;
            }
        }

        System.out.println(Arrays.deepToString(nums));
    }
}
