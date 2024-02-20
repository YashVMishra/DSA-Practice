// https://leetcode.com/problems/missing-number/description/?envType=daily-question&envId=2024-02-20

import java.util.Arrays;

public class Missing_Number {
    public static void main(String[] args) {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    // --------------------------------------------------------------------------------

    public static int missingNumber_2(int[] nums) {
        cyclicSort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    private static void cyclicSort(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correct = nums[i];

            if (correct < nums.length && nums[correct] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
    }
}
