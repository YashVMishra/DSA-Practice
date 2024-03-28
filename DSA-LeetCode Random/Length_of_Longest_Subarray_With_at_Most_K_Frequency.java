// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/?envType=daily-question&envId=2024-03-28

import java.util.HashMap;

public class Length_of_Longest_Subarray_With_at_Most_K_Frequency {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 2, 3, 1, 2 };
        int k = 2;

        System.out.println(maxSubarrayLength(nums, k));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = 0;

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (i < j && map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }

    // --------------------------------------------------------------------------------

    public static int maxSubarrayLength_2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = 0;
        int culprit = 0;

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (map.get(nums[j]) == k + 1) {
                culprit++;
            }

            if (culprit > 0) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == k) {
                    culprit--;
                }

                i++;
            }

            if (culprit == 0) {
                max = Math.max(max, j - i + 1);
            }

            j++;
        }

        return max;
    }
}
