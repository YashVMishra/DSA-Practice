//https://leetcode.com/problems/sum-in-a-matrix/

import java.util.Arrays;

public class Sum_in_a_Matrix {
    public static void main(String[] args) {
        int[][] nums = { { 7, 2, 1 }, { 6, 4, 2 }, { 6, 5, 3 }, { 3, 2, 1 } };
        // System.out.println(matrixSum(nums));
        System.out.println(matrixSum_2(nums));
    }

    // by finding max in every individual array everytime.
    public static int matrixSum(int[][] nums) {
        int score = 0;

        int col = nums[0].length;

        for (int i = 0; i < col; i++) {
            int curr_max = Integer.MIN_VALUE;
            for (int[] arr : nums) {
                int max_index = max(arr);
                curr_max = Math.max(curr_max, arr[max_index]);
                arr[max_index] = Integer.MIN_VALUE;
            }

            score += curr_max;
        }

        return score;
    }

    public static int max(int[] arr) {
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }

        return index;
    }

    // using sorting.
    public static int matrixSum_2(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;
        int sum = 0;

        for (int[] arr : nums) {
            Arrays.sort(arr);
        }

        System.out.println(Arrays.deepToString(nums));

        for (int i = col - 1; i >= 0; i--) {
            int curr_max = Integer.MIN_VALUE;

            for (int j = 0; j < row; j++) {
                curr_max = Math.max(curr_max, nums[j][i]);
            }

            sum += curr_max;
        }

        return sum;
    }
}
