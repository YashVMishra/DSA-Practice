//https://leetcode.com/problems/longest-increasing-subsequence/description/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Longest_Inc_Subsequence {
    public static void main(String[] args) {
        int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
        System.out.println(lengthOfLIS_1(nums));
        System.out.println(lengthOfLIS_2(nums));
        System.out.println(lengthOfLIS_3(nums));
    }

    // brute force method to generate all the subsequence and check for the
    // longest subsequence.
    // In this approach TLE as well as Memory limit exceed will also occur.
    public static int lengthOfLIS_1(int[] nums) {
        List<List<Integer>> list = subsets(nums);

        int max_length = 1;

        for (int i = 0; i < list.size(); i++) {
            if (is_strictly_increasing(list.get(i))) {
                max_length = Math.max(max_length, list.get(i).size());
            }
        }

        return max_length;
    }

    // function to generate subsequence.
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());

        for (int a : nums) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(list.get(i));
                temp.add(a);
                list.add(temp);
            }
        }

        return list;
    }

    // function to check whether the subsequence is strictly increasing or not
    public static boolean is_strictly_increasing(List<Integer> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    // ------------------------------------------------------------------------------------------

    // using recursion.
    public static int lengthOfLIS_2(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        // return helper(0, -1, nums);
        return helper_DP(0, -1, nums, dp);
    }

    // function for LIS_2 method.
    public static int helper(int index, int prevIndex, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        int take = 0;
        int notTake = 0;

        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + helper(index + 1, index, nums);
        }

        notTake = 0 + helper(index + 1, prevIndex, nums);

        return Math.max(take, notTake);
    }

    // using DP.
    public static int helper_DP(int index, int prevIndex, int[] nums, int[][] dp) {
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int take = 0;
        int notTake = 0;

        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + helper_DP(index + 1, index, nums, dp);
        }

        notTake = 0 + helper_DP(index + 1, prevIndex, nums, dp);

        // writing +1 cause at one point we have prevIndex as -1.
        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }

    // ------------------------------------------------------------------------------------------

    // dp method that runs in O(n) time.
    public static int lengthOfLIS_3(int[] nums) {
        int[] dp = new int[nums.length];
        int max_length = 1;

        for (int i = 0; i < dp.length; i++) {
            int curr_length = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    curr_length = Math.max(curr_length, dp[j]);
                }
            }

            dp[i] = curr_length + 1;

            // comparing in the same loop.
            max_length = Math.max(max_length, dp[i]);
        }

        return max_length;
    }
}
