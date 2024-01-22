// https://leetcode.com/problems/set-mismatch/description/?envType=daily-question&envId=2024-01-22

import java.util.Arrays;
import java.util.HashSet;

public class Set_Mismatch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                ans[0] = nums[i];
            } else {
                set.add(nums[i]);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                ans[1] = i;
            }
        }

        return ans;
    }
}
