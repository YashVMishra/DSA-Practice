// https://leetcode.com/problems/number-of-good-pairs/description/?envType=daily-question&envId=2023-10-03

import java.util.HashMap;

public class Number_of_Good_Pairs {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 3 };
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int numIdenticalPairs_2(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            count += map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
