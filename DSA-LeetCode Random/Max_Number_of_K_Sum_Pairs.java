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
        int count = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }

        return count;
    }
}
