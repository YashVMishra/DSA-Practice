// https://leetcode.com/problems/the-number-of-beautiful-subsets/description/

import java.util.HashMap;
import java.util.Map;

public class The_Number_of_Beautiful_Subsets {
    static int result;

    public static void main(String[] args) {
        System.out.println(beautifulSubsets(new int[] { 2, 4, 6 }, 2));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        solve(0, nums, k, map);

        return result - 1;
    }

    private static void solve(int index, int[] nums, int k, Map<Integer, Integer> map) {
        if (index >= nums.length) {
            result++;
            return;
        }

        // not take
        solve(index + 1, nums, k, map);

        // take
        if (!map.containsKey(nums[index] - k) && !map.containsKey(nums[index] + k)) {
            map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
            solve(index + 1, nums, k, map);
            map.put(nums[index], map.getOrDefault(nums[index], 0) - 1);

            if (map.get(nums[index]) == 0) {
                map.remove(nums[index]);
            }
        }
    }
}
