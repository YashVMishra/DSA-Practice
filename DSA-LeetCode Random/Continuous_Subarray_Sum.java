// https://leetcode.com/problems/continuous-subarray-sum/description/?envType=daily-question&envId=2024-06-08

import java.util.HashMap;

public class Continuous_Subarray_Sum {
    public static void main(String[] args) {
        int[] nums = { 23, 2, 4, 6, 7 };
        int k = 6;
        boolean result = checkSubarraySum(nums, k);
        System.out.println(result);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (mp.containsKey(remainder)) {
                if (i - mp.get(remainder) >= 2) {
                    return true;
                }

            } else {
                mp.put(remainder, i);
            }
        }

        return false;
    }
}