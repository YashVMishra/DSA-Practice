// https://leetcode.com/problems/transpose-matrix/description/?envType=daily-question&envId=2023-12-10

import java.util.Arrays;

public class Transpose_Matrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result));
    }

    // we have to use an extra space and dimensions of the matrix
    // changes as on doing its transpose.

    // if the matrix is a square matrix, then we can do it in-place
    // without using any extra space, otherwise we have to use an
    // extra space.
    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                result[col][row] = matrix[row][col];
            }
        }

        return result;
    }

    // -----------------------------------------------------------------------------------

    // if the matrix is a square matrix, then we can do it in-place
    public static int[][] transpose_2(int[][] matrix) {
        int n = matrix.length;

        // we have to iterate only half of the matrix
        // because we are swapping the elements
        // diagonally
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        return matrix;
    }
}