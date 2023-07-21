//https://leetcode.com/problems/search-a-2d-matrix/description/

public class Search_a_2D_Matrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix_2(matrix, target));
        System.out.println(searchMatrix_3(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        for (int[] mat : matrix) {
            if (binarySearch(mat, target)) {
                return true;
            }
        }

        return false;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static boolean searchMatrix_3(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int currElement = matrix[mid / col][mid % col];

            if (currElement == target) {
                return true;
            } else if (currElement > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
