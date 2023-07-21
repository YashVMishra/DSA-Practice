//https://leetcode.com/problems/squares-of-a-sorted-array/description/

import java.util.Arrays;

public class Squares_of_a_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { -7, -3, 2, 3, 11 };
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        return nums;
    }
}
