// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/?envType=daily-question&envId=2023-11-25

import java.util.Arrays;

public class Sum_of_Absolute_Differences_in_a_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5 };
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(nums)));
        System.out.println(Arrays.toString(getSumAbsoluteDifferences_2(nums)));
    }

    // using prefix sum.
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[n - 1] - prefixSum[i];

            int leftCount = i;
            int rightCount = n - i - 1;

            int leftTotal = (leftCount * nums[i]) - leftSum;
            int rightTotal = rightSum - (nums[i] * rightCount);

            result[i] = leftTotal + rightTotal;
        }

        return result;
    }

    // without using prefix sum.
    public static int[] getSumAbsoluteDifferences_2(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        int[] result = new int[n];
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum;
            int rightSum = sum - prefixSum - nums[i];

            int leftCount = i;
            int rightCount = n - i - 1;

            int leftTotal = (leftCount * nums[i]) - leftSum;
            int rightTotal = rightSum - (nums[i] * rightCount);

            result[i] = leftTotal + rightTotal;
            prefixSum += nums[i];
        }

        return result;
    }
}
