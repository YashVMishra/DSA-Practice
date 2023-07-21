//https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1

import java.util.Arrays;

public class Equal_Partition_Sum {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 11, 10, 5 };

        System.out.println(equalPartition(5, arr));
    }

    public static int equalPartition(int N, int arr[]) {
        // code here
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        if (sum % 2 != 0) {
            return 0;
        }

        int half_sum = sum / 2;

        int[][] dp = new int[N][half_sum + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        if (partition(arr, half_sum, arr.length - 1, dp)) {
            return 1;
        }

        else
            return 0;
    }

    public static boolean partition(int[] arr, int target, int index, int[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return (arr[0] == target);
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }

        boolean not_take = partition(arr, target, index - 1, dp);

        boolean take = false;
        if (target >= arr[index]) {
            take = partition(arr, target - arr[index], index - 1, dp);
        }

        dp[index][target] = take || not_take ? 1 : 0;

        return take || not_take;
    }
}
