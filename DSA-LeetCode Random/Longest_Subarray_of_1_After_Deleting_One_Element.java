// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75

public class Longest_Subarray_of_1_After_Deleting_One_Element {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int maxLen = 0;
        int zeroCount = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left);
            right++;
        }

        return maxLen;
    }
}
