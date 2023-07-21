//https://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/

public class Alternating_rectangles_of_O_and_X {
    public static void main(String[] args) {
        char[][] arr = new char[5][5];
        rectangle(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

    }

    public static void rectangle(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int row_start = 0;
        int col_start = 0;
        int row_end = row - 1;
        int col_end = col - 1;
        int char_count = 1;
        int element_count = 0;

        while (row_start <= row_end && col_start <= col_end) {
            char ch;
            if (char_count % 2 == 0) {
                ch = '0';
            }

            else {
                ch = 'X';
            }

            // doing this comparison to avoid duplicate items.

            if (element_count == row * col) {
                break;
            }

            for (int i = col_start; i <= col_end; i++) {
                matrix[row_start][i] = ch;
                element_count++;
            }

            row_start++;

            if (element_count == row * col) {
                break;
            }

            for (int i = row_start; i <= row_end; i++) {
                matrix[i][col_end] = ch;
                element_count++;
            }

            col_end--;

            if (element_count == row * col) {
                break;
            }

            for (int i = col_end; i >= col_start; i--) {
                matrix[row_end][i] = ch;
                element_count++;
            }

            row_end--;

            if (element_count == row * col) {
                break;
            }

            for (int i = row_end; i >= row_start; i--) {
                matrix[i][col_start] = ch;
                element_count++;
            }

            col_start++;

            char_count++;

            // System.out.println("hello");
        }

    }

}
