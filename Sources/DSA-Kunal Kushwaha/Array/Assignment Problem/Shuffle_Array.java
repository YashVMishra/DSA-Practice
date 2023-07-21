//https://leetcode.com/problems/shuffle-the-array/

import java.util.Arrays;

public class Shuffle_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
        System.out.println(Arrays.toString(shuffle2(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
    }

    // first approach
    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];
        int x_counter = 0;
        int y_counter = n;

        for (int i = 0; i < arr.length; i++) {
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

    // second approach
    public static int[] shuffle2(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            ans[i] = nums[k];
            k++;
        }
        for (int i = 1; i < nums.length; i = i + 2) {
            ans[i] = nums[k];
            k++;
        }
        return ans;
    }
}
