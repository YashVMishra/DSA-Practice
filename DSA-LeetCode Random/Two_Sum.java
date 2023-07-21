//https://leetcode.com/problems/two-sum/description/?envType=study-plan&id=level-1

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum_2(nums, target)));
    }

    // using two loops.
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] {};
    }

    // using hashmap
    public static int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
