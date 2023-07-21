//https://leetcode.com/problems/restore-the-array/description/

import java.util.Arrays;

public class Restore_The_Array {
    public static void main(String[] args) {
        String s = "1317";
        int k = 2000;
        System.out.println(numberOfArrays(s, k));
    }

    public static int numberOfArrays(String s, int k) {
        // return solve(s, k, 0);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve_DP(s, k, 0, dp);
    }

    public static int solve(String str, int k, int i) {
        if (i == str.length()) {
            return 1;
        }

        if (str.charAt(i) == '0') {
            return 0;
        }

        int ans = 0;
        long num = 0;
        for (int j = i; j < str.length(); j++) {
            num = num * 10 + (str.charAt(j) - '0');

            if (num > k) {
                break;
            }

            ans = (ans + solve(str, k, j + 1)) % 1000000007;
        }

        return ans;
    }

    public static int solve_DP(String str, int k, int i, int[] dp) {
        if (i == str.length()) {
            return 1;
        }

        if (str.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = 0;
        long num = 0;
        for (int j = i; j < str.length(); j++) {
            num = num * 10 + (str.charAt(j) - '0');

            if (num > k) {
                break;
            }

            ans = (ans + solve_DP(str, k, j + 1, dp)) % 1000000007;
        }

        return dp[i] = ans;
    }
}
