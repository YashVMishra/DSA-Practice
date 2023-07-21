//https://leetcode.com/problems/sort-colors/description/

import java.util.Arrays;

public class Sort_0_1_2 {
    public static void main(String[] args) {
        sortColors(new int[] { 2, 0, 1 });
    }

    public static void sortColors(int[] nums) {
        int count_zero = 0;
        int count_one = 0;
        int count_two = 0;
        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count_zero++;
            }

            if (nums[i] == 1) {
                count_one++;
            }

            if (nums[i] == 2) {
                count_two++;
            }
        }

        // doing this so that we can just know after how many indexes does the new
        // number starts.
        count_one += count_zero;
        count_two += count_one;

        int i = 0;
        while (i < len) {
            if (i >= 0 && i < count_zero) {
                nums[i] = 0;
            }

            if (i >= count_zero && i < count_one) {
                nums[i] = 1;
            }

            if (i >= count_one && i < count_two) {
                nums[i] = 2;
            }

            i++;
        }

        System.out.println(Arrays.toString(nums));
    }
}