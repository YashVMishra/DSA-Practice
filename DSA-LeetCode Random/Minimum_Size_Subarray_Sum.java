//https://leetcode.com/problems/minimum-size-subarray-sum/description/

public class Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        int target = 4;
        int[] nums = { 1, 4, 4 };
        System.out.println(minSubArrayLen(target, nums));
        System.out.println(minSubArrayLen_2(target, nums));
    }

    // shows TLE.
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum >= target) {
                    minLength = Math.min(minLength, j - i + 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // uses sliding window approach.
    // we make the size of the window upto which the sum of the window
    // is less than the target and as soon as the window sum equals or
    // exceeds the target we update the minlength and start removinf elements
    // from the start of the window till the sum exceeds the target sum.
    public static int minSubArrayLen_2(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (end = 0; end < nums.length; end++) {
            currSum += nums[end];

            while (currSum >= target) {
                minLength = Math.min(end - start + 1, minLength);
                currSum -= nums[start++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
