//https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&id=leetcode-75

import java.util.Arrays;

public class Max_Number_of_K_Sum_Pairs {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 3 };
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int operationsCount = 0;

        while (start < end) {
            int sum = nums[start] + nums[end];

            if (sum == k) {
                operationsCount++;
                start++;
                end--;
            }

            else if (sum > k) {
                end--;
            }

            else {
                start++;
            }
        }

        return operationsCount;
    }
}
