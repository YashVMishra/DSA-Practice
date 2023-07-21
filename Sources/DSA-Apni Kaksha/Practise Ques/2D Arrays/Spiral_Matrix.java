//https://leetcode.com/problems/spiral-matrix/

import java.util.ArrayList;

public class Spiral_Matrix {

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        System.out.println(spiralOrder(arr));
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        int row_start = 0;
        int col_start = 0;
        int row_end = row - 1;
        int col_end = col - 1;

        while (row_start <= row_end && col_start <= col_end) {

            // doing this comparison to avoid duplicate items.
            if (list.size() == row * col) {
                break;
            }

            for (int i = col_start; i <= col_end; i++) {
                list.add(matrix[row_start][i]);
            }

            row_start++;

            if (list.size() == row * col) {
                break;
            }

            for (int i = row_start; i <= row_end; i++) {
                list.add(matrix[i][col_end]);
            }

            col_end--;

            if (list.size() == row * col) {
                break;
            }

            for (int i = col_end; i >= col_start; i--) {
                list.add(matrix[row_end][i]);
            }

            row_end--;

            if (list.size() == row * col) {
                break;
            }

            for (int i = row_end; i >= row_start; i--) {
                list.add(matrix[i][col_start]);
            }

            col_start++;

            if (list.size() == row * col) {
                break;
            }
            // System.out.println("hello");
        }

        return list;

    }

}
