// https://leetcode.com/problems/arithmetic-subarrays/description/?envType=daily-question&envId=2023-11-23

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Arithmetic_Subarrays {
    public static void main(String[] args) {
        int[] nums = { 4, 6, 5, 9, 3, 7 };
        int[] l = { 0, 0, 2 };
        int[] r = { 2, 3, 5 };

        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int[] temp = new int[r[i] - l[i] + 1];

            // form an array from the range l[i] to r[i]
            // from the nums array.
            for (int j = l[i]; j <= r[i]; j++) {
                temp[j - l[i]] = nums[j];
            }

            if (isArithmeric(temp)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }

    // check if the array is in AP or not
    // by sorting the array.
    private static boolean isArithmeric(int[] nums) {
        Arrays.sort(nums);
        int diff = nums[1] - nums[0];

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    // second way to check if the array is in AP or not
    // without sorting the array.
    private static boolean isArithmeric_2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int val : nums) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            set.add(val);
        }

        if ((max - min) % (nums.length - 1) != 0) {
            return false;
        }

        int commonDiff = (max - min) / (nums.length - 1);
        int curr = min + commonDiff;

        while (curr < max) {
            if (!set.contains(curr)) {
                return false;
            }

            curr += commonDiff;
        }

        return true;
    }
}
