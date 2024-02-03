// https://leetcode.com/problems/partition-array-for-maximum-sum/description/?envType=daily-question&envId=2024-02-03

import java.util.Arrays;

public class Partition_Array_for_Maximum_Sum {
    private static int n;
    private static int[] t;

    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;

        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        t = new int[501];
        Arrays.fill(t, -1);
        return solve(arr, 0, k);
    }

    private static int solve(int[] arr, int idx, int k) {
        if (idx >= n) {
            return 0;
        }

        if (t[idx] != -1) {
            return t[idx];
        }

        int result = 0;
        int currMax = -1;
        for (int i = idx; i < n && i - idx + 1 <= k; i++) {
            currMax = Math.max(currMax, arr[i]);

            result = Math.max(result, currMax * (i - idx + 1) + solve(arr, i + 1, k));
        }

        return t[idx] = result;
    }
}
