//https://leetcode.com/problems/next-permutation/description/

import java.util.Arrays;

public class Next_Permutation {
    public static void main(String[] args) {
        int[] nums = { 6, 5, 4, 3, 2, 1 };
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        int indexFirst = 0;
        int indexSecond = 0;
        int len = nums.length;

        // loop to find the index of the element whose value is lower than its
        // next index element.
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                indexFirst = i;
                break;
            }
        }

        // loop to find out the index of the element whose value is greater than the
        // element at the indexFirst and only the first element.
        for (int i = len - 1; i >= indexFirst; i--) {
            if (nums[i] > nums[indexFirst]) {
                indexSecond = i;
                break;
            }
        }

        // if both the indexes are 0 then its the last permutation so just reverse
        // the array.
        if (indexFirst == 0 && indexSecond == 0) {
            reverse(nums, 0, len - 1);
            System.out.println(Arrays.toString(nums));
            return;
        }

        swap(nums, indexFirst, indexSecond);

        reverse(nums, indexFirst + 1, len - 1);

        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
