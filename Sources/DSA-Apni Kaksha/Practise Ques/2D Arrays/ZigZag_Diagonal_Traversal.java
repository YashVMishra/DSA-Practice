//https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/

import java.util.ArrayList;

class ZigZag_Diagonal_Traversal {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3 }, { 4, 5, 6 },
                { 7, 8, 9 } };

        System.out.println("The Given Matrix is : ");
        printMatrix(arr);

        System.out.println("Diagonal Traversal of the Matrix is : ");
        traversal(arr);

        System.out.println("Diagonal Traversal of the Matrix is : ");
        System.out.println(traveral_2(arr));

    }

    // checking the same condition many time. Not a good complexity.
    static void traversal(int[][] arr) {
        int sum = 0;
        int row_count = 0;
        int row = arr.length;
        int col = arr[0].length;

        while (sum <= (row * col - 2)) {
            for (int i = row_count; i >= 0; i--) {
                for (int j = 0; j < col; j++) {
                    if (i + j == sum) {
                        System.out.print(arr[i][j] + "  ");
                    }
                }
            }
            System.out.println();
            sum++;

            if (row_count >= row - 1) {
                row_count = row - 1;
            }

            else {
                row_count++;
            }
        }

    }

    static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "      ");
            }
            System.out.println();
        }
    }

    // optimum solution checking the indexes for above the main diagonal and later
    // below it.
    public static ArrayList<Integer> traveral_2(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        ArrayList<Integer> list = new ArrayList<>();

        // write down the indexes of each element and then try to make a pattern out of
        // it.
        // for elements above the main diagonal including the main diagonal
        for (int i = 0; i <= col - 1; i++) {
            int k = i;
            for (int j = 0; j <= i; j++) {
                list.add(arr[j][k]);
                k--;
            }
        }

        // for rest of the elements.
        // use the same appraoch.
        for (int i = 1; i < row; i++) {
            int k = col - 1;
            for (int j = i; j <= row - 1; j++) {
                list.add(arr[j][k]);
                k--;
            }
        }

        return list;
    }
}