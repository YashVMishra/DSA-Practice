//m/problems/longest-subarray-of-1s-after-deleting-one-element/description/

public class Longest_Subarray_of_1_After_Deleting_One_Element {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        int zeroCount = 0;

        // start of the window.
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0) ? 1 : 0;

            // as soon as the zeroCount exceed 1 then we start decreasing the size
            // of the window till we have only one zero.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0) ? 1 : 0;
                start++;
            }

            maxLength = Math.max(maxLength, i - start);
        }

        return maxLength;
    }
}
