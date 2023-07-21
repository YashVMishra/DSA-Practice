//https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

import java.util.HashMap;

public class Subarray_Sums_Divisible_by_K {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
        System.out.println(subarraysDivByK_2(nums, k));
    }

    // shows TLE.
    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr_sum = nums[i];

            if (curr_sum % k == 0) {
                count++;
            }

            for (int j = i + 1; j < nums.length; j++) {
                curr_sum += nums[j];

                if (curr_sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    // uses extra space.
    public static int subarraysDivByK_2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // stores the frequncy of reaminders. (remainder, value)
        map.put(0, 1);
        int curr_sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            curr_sum += nums[i];
            int rem = curr_sum % k;

            // imp for negative remainders.
            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}