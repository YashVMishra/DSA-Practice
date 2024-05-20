// https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/

import java.util.ArrayList;
import java.util.List;

public class Sum_of_All_Subset_XOR_Totals {
    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        int result = subsetXORSum(nums);
        System.out.println(result);
    }

    // Approach-1 (Using simple backtracking to generate subsets)
    // T.C : O(n * 2^n)
    // S.C : O(n * 2^n)
    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();
        solve(nums, 0, currSubset, subsets);

        int result = 0;
        for (List<Integer> subset : subsets) {
            int xor = 0;
            for (int num : subset) {
                xor ^= num;
            }

            result += xor;
        }

        return result;
    }

    private static void solve(int[] nums, int i, List<Integer> currSubset, List<List<Integer>> subsets) {
        if (i == nums.length) {
            subsets.add(new ArrayList<>(currSubset));
            return;
        }

        currSubset.add(nums[i]);
        solve(nums, i + 1, currSubset, subsets);
        currSubset.remove(currSubset.size() - 1);
        solve(nums, i + 1, currSubset, subsets);
    }

    // ---------------------------------------------------------------------------------

    // Approach-2 (Using optimal backtracking)
    // T.C : O(2^n)
    // S.C : O(n)
    public static int subsetXORSum_2(int[] nums) {
        return solve(0, nums, 0);
    }

    private static int solve(int i, int[] nums, int Xor) {
        if (i == nums.length) {
            return Xor;
        }

        int include = solve(i + 1, nums, nums[i] ^ Xor);
        int exclude = solve(i + 1, nums, Xor);

        return include + exclude;
    }

    // ---------------------------------------------------------------------------------

    // Approach-3 (Observing pattern)
    // T.C : O(n)
    // S.C : O(1)
    public static int subsetXORSum_3(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int num : nums) {
            result |= num;
        }

        return result << (n - 1);
    }
}
