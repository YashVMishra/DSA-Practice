// https://leetcode.com/problems/single-number-iii/description/

import java.util.Arrays;
import java.util.HashSet;

public class Single_Number_3 {
    public static void main(String[] args) {
        int[] nums = { 0, 1 };
        System.out.println(Arrays.toString(singleNumber(nums)));
        System.out.println(Arrays.toString(singleNumber_2(nums)));
    }

    // using extra space.
    public static int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                continue;
            }

            set.add(num);
        }

        int[] result = new int[2];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }

        return result;
    }

    // --------------------------------------------------------------------------------

    public static int[] singleNumber_2(int[] nums) {
        long xor_r = 0;

        // Perform XOR for all elements to find xor_r
        for (int num : nums) {
            xor_r ^= num;
        }

        // Find the rightmost set bit (mask)
        long mask = xor_r & (-xor_r);

        int groupa = 0;
        int groupb = 0;

        // Divide the numbers into two groups and perform XOR in each group
        for (int num : nums) {
            if ((num & mask) != 0) {
                groupa ^= num;
            } else {
                groupb ^= num;
            }
        }

        // Return the two unique numbers
        return new int[] { groupa, groupb };
    }
}
