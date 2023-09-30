// https://leetcode.com/problems/132-pattern/description/?envType=daily-question&envId=2023-09-30

import java.util.Stack;

public class One_Three_Two_Pattern {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        System.out.println(find132pattern(nums));
    }

    // TLE
    // brute force.
    public static boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] > nums[i] && nums[k] < nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    // -------------------------------------------------------------------------------------

    // also shows TLE.
    public static boolean find132pattern_2(int[] nums) {
        int min = nums[0];

        for (int j = 1; j < nums.length; j++) {
            min = Math.min(min, nums[j]);

            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] > min && nums[k] < nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // -------------------------------------------------------------------------------------

    // O(n) solution.
    // using monotonic stack.
    public static boolean find132pattern_3(int[] nums) {
        int min = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                return true;
            }

            while (stack.isEmpty() == false && nums[i] > stack.peek()) {
                min = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}
