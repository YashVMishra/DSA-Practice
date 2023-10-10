// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/description/?envType=daily-question&envId=2023-10-10

import java.util.Arrays;
import java.util.HashSet;

public class Minimum_Number_of_Operations_to_Make_Array_Continuous {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 5, 3 };
        System.out.println(minOperations(nums));
    }

    // brute force
    // shows TLE
    public static int minOperations(int[] nums) {
        int diff = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = min + diff;
            HashSet<Integer> set = new HashSet<>();
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (set.contains(nums[j])) {
                    count++;
                    continue;
                }

                if (nums[j] >= min && nums[j] <= max) {
                    set.add(nums[j]);
                } else {
                    count++;
                }
            }

            ans = Math.min(ans, count);
        }

        return ans;
    }

    // optimal
    // slight changes in the above code.
    public static int minOperations_2(int[] nums) {
        int n = nums.length;
        int ans = n;

        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }

        int[] newNums = new int[unique.size()];
        int index = 0;

        for (int num : unique) {
            newNums[index++] = num;
        }

        Arrays.sort(newNums);

        int j = 0;
        for (int i = 0; i < newNums.length; i++) {
            while (j < newNums.length && newNums[j] < newNums[i] + n) {
                j++;
            }

            int count = j - i;
            ans = Math.min(ans, n - count);
        }

        return ans;
    }
}
