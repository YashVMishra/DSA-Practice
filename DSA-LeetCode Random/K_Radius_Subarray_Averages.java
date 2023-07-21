//https://leetcode.com/problems/k-radius-subarray-averages/description/

import java.util.Arrays;

public class K_Radius_Subarray_Averages {
    public static void main(String[] args) {
        int[] nums = { 8 };
        int k = 10000;
        System.out.println(Arrays.toString(getAverages(nums, k)));
        System.out.println(Arrays.toString(getAverages_2(nums, k)));
    }

    // shows TLE.
    public static int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((i + k) >= nums.length || (i - k) < 0) {
                ans[index] = -1;
            }

            else {
                int average = avg(nums, i - k, i + k);
                ans[index] = average;
            }

            index++;
        }

        return ans;
    }

    public static int avg(int[] nums, int start, int end) {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }

        return (int) (sum / (end - start + 1));
    }

    // using the concept of prefix sum.
    // calculate the prefix sum of the given array and be sure to make it
    // as long ans sum can overflow.

    // then just calculate the average of the given range and store it in the
    // ans array.
    public static int[] getAverages_2(int[] nums, int k) {
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        int[] ans = new int[nums.length];
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if ((i + k) >= nums.length || (i - k) < 0) {
                ans[index] = -1;
            }

            else {
                int average;

                // this case is imp as in the first subarray the index value of i - k - 1 will
                // be less than 0 so it will throw an error, so thats why.
                if (i - k - 1 < 0) {
                    average = (int) ((prefixSum[i + k]) / (2 * k + 1));
                } else {
                    average = (int) ((prefixSum[i + k] - prefixSum[i - k - 1]) / (2 * k + 1));
                }

                ans[index] = average;
            }

            index++;
        }

        return ans;
    }
}
