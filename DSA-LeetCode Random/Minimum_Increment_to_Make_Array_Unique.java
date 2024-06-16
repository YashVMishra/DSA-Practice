// https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/?envType=daily-question&envId=2024-06-14

import java.util.Arrays;

public class Minimum_Increment_to_Make_Array_Unique {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 2, 1, 7 };
        System.out.println(minIncrementForUnique(nums));
        System.out.println(minIncrementForUnique_2(nums));
    }

    // using normal sort.
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int moves = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                moves += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }

        return moves;
    }

    // using counting sort
    public static int minIncrementForUnique_2(int[] nums) {
        int n = nums.length;
        int maxElement = 0;
        int moves = 0;

        for (int val : nums) {
            maxElement = Math.max(maxElement, val);
        }

        int[] count = new int[n + maxElement];

        for (int val : nums) {
            count[val]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] <= 1)
                continue;

            int extra = count[i] - 1;
            count[i + 1] += extra;
            count[i] = 1;
            moves += extra;
        }

        return moves;
    }
}
