// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

import java.util.Arrays;
import java.util.HashSet;

public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int ans = set.size();
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                nums[index] = nums[i];
                set.remove(nums[i]);
                index++;
            }
        }

        return ans;
    }
}
