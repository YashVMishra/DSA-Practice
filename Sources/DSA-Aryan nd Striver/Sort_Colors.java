//https://leetcode.com/problems/sort-colors/description/

import java.util.Arrays;

public class Sort_Colors {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;

        for (int i : nums) {
            if (i == 0) {
                countZero++;
            } else if (i == 1) {
                countOne++;
            } else {
                countTwo++;
            }
        }

        for (int i = 0; i < countZero; i++) {
            nums[i] = 0;
        }

        for (int i = countZero; i < countOne + countZero; i++) {
            nums[i] = 1;
        }

        for (int i = countZero + countOne; i < countOne + countZero + countTwo; i++) {
            nums[i] = 2;
        }

        System.out.println(Arrays.toString(nums));
    }
}
