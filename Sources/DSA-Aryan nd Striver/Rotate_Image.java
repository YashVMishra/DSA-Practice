//https://leetcode.com/problems/rotate-image/description/

import java.util.Arrays;

public class Rotate_Image {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        int colStart = 0;
        int colEnd = col - 1;

        while (colStart < colEnd) {
            for (int i = 0; i < row; i++) {
                swap(matrix, i, colStart, i, colEnd);
            }

            colStart++;
            colEnd--;
        }
    }

    public static void swap(int[][] matrix, int a, int b, int x, int y) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[x][y];
        matrix[x][y] = temp;
    }
}
