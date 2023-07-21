//https://leetcode.com/problems/move-zeroes/description/

import java.util.Arrays;

public class Move_Zeroes {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, index, i);
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[index] = 0;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
