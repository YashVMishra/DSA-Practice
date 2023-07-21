//https://leetcode.com/problems/rotate-array/description/

import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int element = temp[i];
            int index = (i + k) % nums.length;
            nums[index] = element;

        }
    }
}
