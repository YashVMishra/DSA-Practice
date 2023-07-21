//https://leetcode.com/problems/shuffle-the-array/description/

import java.util.Arrays;

public class Shuffle_Array {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = 3;
        System.out.println(Arrays.toString(shuffle(nums, n)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];

        int x_counter = 0;
        int y_counter = n;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                arr[i] = nums[x_counter];
                x_counter++;
            }

            else {
                arr[i] = nums[y_counter];
                y_counter++;
            }
        }

        return arr;
    }
}
