//https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan&id=level-2

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int down = row - 1;

        while (left <= right && top <= down) {

            // right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }

            top++;

            // down
            for (int i = top; i <= down; i++) {
                list.add(matrix[i][right]);
            }

            right--;

            // left

            // imp condition.
            if (top <= down) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }

                down--;
            }

            // top

            // imp condition.
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    list.add(matrix[i][left]);
                }

                left++;
            }
        }

        return list;
    }
}
