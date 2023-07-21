//https://leetcode.com/problems/single-number-ii/description/

import java.util.Arrays;
import java.util.HashMap;

public class Single_Number_2 {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 3, 4, 4, 4 };
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber_2(nums));
    }

    // uses extra space.
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : nums) {
            if (map.get(i) == 1) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    // using sorting
    public static int singleNumber_2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        // if the first element is the single element.
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // if the last element is the single element.
        if (nums[nums.length - 2] != nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }

        int index = 1;
        int ans = -1;
        while (index < nums.length) {
            if (nums[index] != nums[index - 1]) {
                ans = nums[index - 1];
                break;
            } else {
                index += 3;
            }
        }

        return ans;
    }
}
