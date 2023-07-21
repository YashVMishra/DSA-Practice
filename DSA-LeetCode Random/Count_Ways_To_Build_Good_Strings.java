//https://leetcode.com/problems/count-ways-to-build-good-strings/description/

import java.util.Arrays;

public class Count_Ways_To_Build_Good_Strings {
    static int mod = 1000000007;

    public static void main(String[] args) {
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(countGoodStrings(low, high, zero, one));
        System.out.println(countGoodStrings_2(low, high, zero, one));
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        for (int end = low; end <= high; end++) {
            ans += dfs_DP(end, zero, one, dp) % mod;
            ans %= mod;
        }

        return ans;
    }

    // using recursion
    // shows TLE.
    public static int dfs(int end, int zero, int one) {

        // base case.
        if (end == 0) {
            return 1;
        }

        int count = 0;

        if (end >= zero) {
            count += dfs(end - zero, zero, one) % mod;
        }

        if (end >= one) {
            count += dfs(end - one, zero, one) % mod;
        }

        return count % mod;
    }

    // using DP.
    public static int dfs_DP(int end, int zero, int one, int[] dp) {

        // base case
        if (end == 0) {
            return 1;
        }

        if (dp[end] != -1) {
            return dp[end];
        }

        int count = 0;

        if (end >= zero) {
            count += dfs_DP(end - zero, zero, one, dp) % mod;
        }

        if (end >= one) {
            count += dfs_DP(end - one, zero, one, dp) % mod;
        }

        dp[end] = count;

        return dp[end] % mod;
    }

    // iterative approach
    // since we need only the values of two things that is
    // dp[i-one] and dp[i-zero] for each computation so we can do it
    // iteratively also.
    public static int countGoodStrings_2(int low, int high, int zero, int one) {
        int ans = 0;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            int count = 0;

            if (i >= zero) {
                count += dp[i - zero] % mod;
            }

            if (i >= one) {
                count += dp[i - one] % mod;
            }

            dp[i] = count % mod;
        }

        for (int i = low; i <= high; i++) {
            ans += dp[i] % mod;
            ans %= mod;
        }

        return ans;
    }
}
