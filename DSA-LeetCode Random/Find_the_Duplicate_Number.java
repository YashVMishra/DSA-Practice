// https://leetcode.com/problems/find-the-duplicate-number/description/?envType=daily-question&envId=2023-09-19

import java.util.Arrays;
import java.util.HashSet;

public class Find_the_Duplicate_Number {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate_2(nums));
        System.out.println(findDuplicate_3(nums));
        System.out.println(findDuplicate_4(nums));
    }

    // accepted but not good as it modifies the input
    // and in the ques modification is not allowed
    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ans = nums[i];
                break;
            }
        }

        return ans;
    }

    // ----------------------------------------------------------------------------------

    // does not modify the input
    // but uses extra space
    public static int findDuplicate_2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for (int i : nums) {
            if (set.contains(i)) {
                ans = i;
                break;
            } else {
                set.add(i);
            }
        }

        return ans;
    }

    // ------------------------------------------------------------------------------------

    // intuition is to use count sort
    // takes constant space but modifies the input
    public static int findDuplicate_3(int[] nums) {
        countSort(nums);
        return nums[nums.length - 1];
    }

    private static void countSort(int[] nums) {
        int index = 0;

        while (index < nums.length) {
            int correctIndex = nums[index] - 1;

            if (nums[index] != nums[correctIndex]) {
                swap(nums, index, correctIndex);
            } else {
                index++;
            }
        }
    }

    private static void swap(int[] nums, int index, int correctIndex) {
        int temp = nums[index];
        nums[index] = nums[correctIndex];
        nums[correctIndex] = temp;
    }

    // -------------------------------------------------------------------------------

    // using slow and fast pointer
    // also called hare and tortoise algo
    public static int findDuplicate_4(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // do {
        // slow = nums[slow];
        // fast = nums[nums[fast]];
        // } while (slow != fast);

        // this while loop can also be written using
        // do-while as coded above.
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
