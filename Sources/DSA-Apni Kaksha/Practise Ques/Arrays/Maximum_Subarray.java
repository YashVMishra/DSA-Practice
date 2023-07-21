//https://leetcode.com/problems/maximum-subarray/description/

public class Maximum_Subarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { 5, -3, 5 }));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
