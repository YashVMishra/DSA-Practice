//https://leetcode.com/problems/majority-element/description/

import java.util.HashMap;
import java.util.Set;

public class Majority_Element {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement_2(nums));
    }

    // does not show TLE but not a good TC.
    public static int majorityElement(int[] nums) {
        int count = 1;
        int value = (int) (Math.floor(nums.length / 2));
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > value) {
                ans = nums[i];
                break;
            }

            count = 1;
        }

        return ans;
    }

    public static int majorityElement_2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int value = (int) (Math.floor(nums.length / 2));
        int ans = 0;

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Integer> set = map.keySet();

        for (int i : set) {
            if (map.get(i) > value) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}
