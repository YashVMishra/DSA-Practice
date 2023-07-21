//https://leetcode.com/problems/partition-equal-subset-sum/description/?envType=study-plan&id=level-2

import java.util.Arrays;

public class Partition_Equal_Subset {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 5, 11 };

        System.out.println(canPartition(arr));
    }

    public static boolean canPartition(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[arr.length][target + 1];
        for (int[] nums : dp) {
            Arrays.fill(nums, -1);
        }

        if (partition_DP(arr, target, 0, dp)) {
            return true;
        }

        return false;
    }

    // using recursion
    // shows TLE.
    public static boolean partition(int[] arr, int target, int index) {
        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        if (index >= arr.length) {
            return false;
        }

        boolean take = partition(arr, target - arr[index], index + 1);
        boolean notTake = partition(arr, target, index + 1);

        return take || notTake;
    }

    // using DP.
    public static boolean partition_DP(int[] arr, int target, int index, int[][] dp) {
        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        if (index >= arr.length) {
            return false;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }

        boolean take = partition_DP(arr, target - arr[index], index + 1, dp);
        boolean notTake = partition_DP(arr, target, index + 1, dp);

        dp[index][target] = take || notTake ? 1 : 0;

        return take || notTake;
    }

}
