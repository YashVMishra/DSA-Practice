// https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1?page=1&company[]=SAP%20Labs&sortBy=submissions

// for the second function read
// https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/

public class Search_in_a_matrix {
    public static void main(String[] args) {
        int[][] mat = { { 3, 30, 38 }, { 44, 52, 54 }, { 57, 60, 69 } };
        System.out.println(matSearch(mat, mat.length, mat[0].length, 62));
        System.out.println(matSearch_2(mat, mat.length, mat[0].length, 62));
    }

    public static int matSearch(int mat[][], int N, int M, int X) {
        for (int[] arr : mat) {
            if (binarySearch(arr, X)) {
                return 1;
            }
        }

        return 0;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public static int matSearch_2(int matrix[][], int N, int M, int X) {
        int i = 0;
        int j = M - 1;

        while (i < N && j >= 0) {
            int element = matrix[i][j];

            if (element == X) {
                return 1;
            } else if (element > X) {
                j--; // ignoring the elements in the column below the element.
            } else {
                i++; // ignoring the element in the row.
            }
        }

        return 0;
    }
}
