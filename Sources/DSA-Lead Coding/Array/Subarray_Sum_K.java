//https://leetcode.com/problems/subarray-sum-equals-k/description/

import java.util.HashMap;

public class Subarray_Sum_K {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println(subarraySum(nums, 0));
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // putting zero for the first subarray.
        map.put(0, 1);

        int count = 0;
        int curr_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            curr_sum += nums[i];

            if (map.containsKey(curr_sum - k)) {
                count += map.get(curr_sum - k);
            }

            map.put(curr_sum, map.getOrDefault(curr_sum, 0) + 1);
        }

        return count;
    }
}