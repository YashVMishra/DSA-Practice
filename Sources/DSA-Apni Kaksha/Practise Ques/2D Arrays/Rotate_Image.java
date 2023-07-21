
public class Rotate_Image {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(arr);
        // System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        int col_start = 0;
        int col_end = col - 1;

        while (col_start <= col_end) {
            for (int i = 0; i < row; i++) {
                swap(matrix, i, col_start, i, col_end);
            }
            col_start++;
            col_end--;
        }
    }

    public static void swap(int[][] arr, int a, int b, int x, int y) {
        int temp = arr[a][b];
        arr[a][b] = arr[x][y];
        arr[x][y] = temp;
    }
}
