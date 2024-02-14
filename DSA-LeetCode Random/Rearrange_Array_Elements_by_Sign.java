// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/?envType=daily-question&envId=2024-02-14

import java.util.Arrays;

public class Rearrange_Array_Elements_by_Sign {
    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };
        int[] result = rearrangeArray(nums);

        System.out.println(Arrays.toString(result));
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] positive = new int[nums.length / 2];
        int[] negative = new int[nums.length / 2];

        for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative[j++] = nums[i];
            } else {
                positive[k++] = nums[i];
            }
        }

        for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = positive[j++];
            } else {
                nums[i] = negative[k++];
            }
        }

        return nums;
    }
}
