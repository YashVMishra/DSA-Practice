//https://leetcode.com/problems/longest-increasing-subsequence/description/

import java.util.List;
import java.util.ArrayList;

public class Longest_Inc_Subsequence {
    public static void main(String[] args) {
        int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
        System.out.println(lengthOfLIS_2(nums));
    }

    // brute force method to generate all the subsequence and check for the
    // longest subsequence.
    // In this approach TLE as well as Memory limit exceed will also occur.
    public static int lengthOfLIS(int[] nums) {
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);

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

    // dp method that runs in O(n) time.
    public static int lengthOfLIS_2(int[] nums) {
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
