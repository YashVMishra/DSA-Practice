//https://leetcode.com/problems/maximum-subarray/description/

public class Maximum_Subarray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
    }

    // using Kadane's Algorithm.
    public static int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
