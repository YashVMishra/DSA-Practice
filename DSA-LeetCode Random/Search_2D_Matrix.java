//https://leetcode.com/problems/search-a-2d-matrix/description/

import java.util.Arrays;

public class Search_2D_Matrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix_2(matrix, 3));
        System.out.println(searchMatrix_3(matrix, 3));
        System.out.println(searchMatrix_4(matrix, 3));
        System.out.println(searchMatrix_5(matrix, 3));
    }

    // By surprise, this method does not show TLE.
    // TC - O(m * n)
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // also does not show TLE
    // TC - O(m * log n)
    public static boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        for (int[] arr : matrix) {
            if (Arrays.binarySearch(arr, target) >= 0) {
                return true;
            }
        }

        return false;
    }

    // uses two pointer approach
    public static boolean searchMatrix_3(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] > target) {
                col--;
            }

            else {
                row++;
            }
        }

        return false;
    }

    // uses extra space of O(m * n);
    // TC - O(log(m*n))
    public static boolean searchMatrix_4(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int[] temp = new int[matrix.length * matrix[0].length];

        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[index++] = matrix[i][j];
            }
        }

        if (Arrays.binarySearch(temp, target) >= 0) {
            return true;
        }

        else {
            return false;
        }

    }

    // uses the concept of binary search.
    // marked the boxes as 0,1,2.... (m*n)-1;
    // apply Binary Search on these indexes.
    public static boolean searchMatrix_5(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid / col][mid % col] == target) {
                return true;
            }

            if (matrix[mid / col][mid % col] > target) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return false;

    }
}
