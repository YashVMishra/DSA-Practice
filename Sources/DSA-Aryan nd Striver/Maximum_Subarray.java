//https://leetcode.com/problems/maximum-subarray/description/

public class Maximum_Subarray {
    public static void main(String[] args) {
        int[] nums = { 5, 4, -1, 7, 8 };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
