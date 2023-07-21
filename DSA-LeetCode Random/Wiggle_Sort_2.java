//https://leetcode.com/problems/wiggle-sort-ii/description/

import java.util.Arrays;

public class Wiggle_Sort_2 {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 1, 1, 6, 4 };
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        if (nums.length <= 2) {
            return;
        }

        int[] temp = new int[nums.length];

        int count = 0;
        int i = 1;
        int j = nums.length - 1;
        while (count < 2) {
            while (i < nums.length) {
                temp[i] = nums[j];
                j--;
                i = i + 2;
            }
            i = 0;
            count++;
        }

        for (int k = 0; k < nums.length; k++) {
            nums[k] = temp[k];
        }

        return;
    }

}
