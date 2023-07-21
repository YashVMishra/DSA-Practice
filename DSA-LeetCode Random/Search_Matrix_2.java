//https://leetcode.com/problems/search-a-2d-matrix-ii/description/

import java.util.Arrays;

public class Search_Matrix_2 {
    public static void main(String[] args) {
        int[][] arr = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        System.out.println(searchMatrix(arr, 5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int[] arr : matrix) {
            if (Arrays.binarySearch(arr, target) != -1) {
                return true;
            }
        }

        return false;
    }
}