// https://leetcode.com/problems/squares-of-a-sorted-array/description/?envType=daily-question&envId=2024-03-02

import java.util.Arrays;

public class Squares_of_a_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { -7, -3, 2, 3, 11 };
        int[] result = sortedSquares(nums);

        System.out.println(Arrays.toString(result));
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;

        // since the array is sorted
        // we can compare the first and last element
        // and swap accordingly.
        while (start <= end) {
            if (nums[start] > nums[end]) {
                result[index] = nums[start];
                start++;
            } else {
                result[index] = nums[end];
                end--;
            }

            index--;
        }

        return result;
    }
}
