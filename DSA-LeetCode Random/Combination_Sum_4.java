import java.util.Arrays;

public class Combination_Sum_4 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;

        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return helper_DP(nums, target, 0, memo);
    }

    // recursion
    public static int helper(int[] nums, int target, int sum) {
        if (target == sum) {
            return 1; // Found a valid combination
        }

        if (sum > target) {
            return 0; // Invalid combination
        }

        int totalWays = 0;
        for (int i = 0; i < nums.length; i++) {
            totalWays += helper(nums, target, sum + nums[i]);
        }

        return totalWays;
    }

    // DP - memoization
    public static int helper_DP(int[] nums, int target, int sum, int[] memo) {
        if (target == sum) {
            return 1; // Found a valid combination
        }

        if (sum > target) {
            return 0; // Invalid combination
        }

        if (memo[sum] != -1) {
            return memo[sum];
        }

        int totalWays = 0;
        for (int i = 0; i < nums.length; i++) {
            totalWays += helper_DP(nums, target, sum + nums[i], memo);
        }

        memo[sum] = totalWays;
        return totalWays;
    }
}
