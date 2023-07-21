//https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/

import java.util.Arrays;

public class Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 3, 4, 6, 7 };
        int target = 12;
        System.out.println(numSubseq(nums, target));
    }

    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int mod = 1000000007;

        int[] power = new int[len];
        power[0] = 1;

        for (int i = 1; i < len; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int left = 0;
        int right = len - 1;
        int ans = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                ans += (power[right - left]) % mod;
                left++;
            }

            else {
                right--;
            }
        }

        return ans;

    }
}
