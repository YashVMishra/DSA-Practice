// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/?envType=daily-question&envId=2023-09-20

import java.util.HashMap;

public class Minimum_Operations_to_Reduce_X_to_Zero {
    static int minCount;

    public static void main(String[] args) {
        int[] nums = { 1, 1, 4, 2, 3 };
        int x = 5;
        System.out.println(minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        minCount = Integer.MAX_VALUE;

        solve(nums, x, 0, 0, n - 1);

        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }

        return minCount;
    }

    // recursion
    public static void solve(int[] nums, int remain, int count, int i, int j) {
        if (remain == 0) {
            minCount = Math.min(minCount, count);
            return;
        } else if (remain < 0 || i > j || count >= minCount)
            return;
        else {
            solve(nums, remain - nums[i], count + 1, i + 1, j);
            solve(nums, remain - nums[j], count + 1, i, j - 1);
        }
    }

    // ----------------------------------------------------------------------------------------

    public static int minOperations_2(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            mp.put(sum, i);
        }

        if (sum < x) {
            return -1;
        }

        int restSum = sum - x;
        int longest = Integer.MIN_VALUE;
        sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (mp.containsKey(sum - restSum)) {
                longest = Math.max(longest, i - mp.get(sum - restSum));
            }
        }

        return longest == Integer.MIN_VALUE ? -1 : n - longest;
    }
}
