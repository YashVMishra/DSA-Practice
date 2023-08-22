// https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class Remove_Element {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    // this method also maintains the relative order of the elements.
    public static int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
