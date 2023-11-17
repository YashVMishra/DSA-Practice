// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/?envType=daily-question&envId=2023-11-17

import java.util.Arrays;

public class Minimize_Maximum_Pair_Sum_in_Array {
    public static void main(String[] args) {
        System.out.println(minPairSum(new int[] { 3, 5, 2, 3 }));
    }

    // here minimized means, lets say we have an array [3, 5, 2, 3]
    // we can pair up as (3, 5) and (2, 3) then here answer will be
    // 8, but if we pair as (2, 5) and (3, 3) then answer will be 7
    // so we have to minimize the maximum sum of the pair, so the answer
    // will be 7.

    // so we can sort the array and then pair up the first and last element
    // that will give us the minimum sum of the pair.

    // as pairing up last two elements after sorting will
    // give us the maximum sum of the pair
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            max = Math.max(max, nums[left] + nums[right]);
            left++;
            right--;
        }

        return max;
    }
}
