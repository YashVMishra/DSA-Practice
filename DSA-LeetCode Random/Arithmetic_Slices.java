// https://leetcode.com/problems/arithmetic-slices/description/

public class Arithmetic_Slices {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };

        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int slices = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                slices += dp[i];
            }
        }

        return slices;
    }

    // since in the above ques we just want the previous value
    // we can use a variable instead of an array.
    public static int numberOfArithmeticSlices_2(int[] nums) {
        int dp = 0;
        int slices = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp = 1 + dp;
                slices += dp;
            } else {
                dp = 0;
            }
        }

        return slices;
    }

    // we can also derive a formula for the number of slices
    // if we can count how many times the
    // difference between the consecutive elements is same.
    // then we can use that count to find the number of slices.
    public static int numberOfArithmeticSlices_3(int[] nums) {
        int count = 0;
        int slices = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count++;
            } else {
                slices += (count * (count + 1)) / 2;
                count = 0;
            }
        }

        // if the last elements are in AP then we need to add
        // the slices for them as well.
        return (slices + (count * (count + 1)) / 2);
    }
}
