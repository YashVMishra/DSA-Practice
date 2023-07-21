// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

import java.util.Arrays;

public class Number_of_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] count = new int[len];
        int[] length = new int[len];

        Arrays.fill(count, 1);
        Arrays.fill(length, 1);

        int maxLen = 1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }

            maxLen = Math.max(maxLen, length[i]);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (length[i] == maxLen) {
                ans += count[i];
            }
        }

        return ans;
    }
}
