// https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashSet;

public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                nums[index] = nums[i];
                index++;
                set.add(nums[i]);
            }
        }

        return index; // you can also return the size of the set.
    }
}
