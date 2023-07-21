//https://leetcode.com/problems/longest-arithmetic-subsequence/description/

import java.util.Arrays;

public class Longest_Arithmetic_Subsequence {
    public static void main(String[] args) {
        int[] nums = { 9, 4, 7, 2, 10 };
        System.out.println(longestArithSeqLength(nums));
    }

    public static int longestArithSeqLength(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        int[] index = new int[1001];
        Arrays.fill(index, -1);

        int max = 2;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);

            for (int j = i + 1; j < n; j++) {
                int first = A[i] * 2 - A[j];
                if (first < 0 || index[first] == -1)
                    continue;

                dp[i][j] = dp[index[first]][i] + 1;
                max = Math.max(max, dp[i][j]);
            }

            index[A[i]] = i;
        }

        return max;
    }
}
