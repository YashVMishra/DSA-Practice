//https://leetcode.com/problems/matrix-diagonal-sum/description/

public class Matrix_Diagonal_Sum {
    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
        System.out.println(diagonalSum(mat));
        System.out.println(diagonalSum_2(mat));
    }

    // using O(n^2) TC.
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                // for left diagonal i == j
                // for right diagonal i + j == len -1 ( by observation).
                if (i + j == len - 1 || i == j) {
                    sum += mat[i][j];
                }
            }
        }

        return sum;
    }

    // using linear TC.
    public static int diagonalSum_2(int[][] mat) {
        int len = mat.length;
        int sum = 0;

        for (int i = 0; i < len; i++) {

            // for left diagonal.
            sum += mat[i][i];

            // for right diagonal
            sum += mat[i][len - 1 - i];
        }

        // if the len is even then the middle element is calculated two time
        // so we have to delete ot one time.
        if (len % 2 != 0) {
            sum -= mat[len / 2][len / 2];
        }

        return sum;
    }
}
