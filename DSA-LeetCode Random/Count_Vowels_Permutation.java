// https://leetcode.com/problems/count-vowels-permutation/description/?envType=daily-question&envId=2023-10-28

import java.util.Arrays;

public class Count_Vowels_Permutation {
    private static final int M = 1000000007;
    private static final int a = 0, e = 1, i = 2, o = 3, u = 4;
    private static long[][] dp;

    public static void main(String[] args) {
        System.out.println(countVowelPermutation(1));
        System.out.println(countVowelPermutation(2));
        System.out.println(countVowelPermutation(5));
        System.out.println(countVowelPermutation(144));
    }

    public static int countVowelPermutation(int n) {
        dp = new long[5][n + 1];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], -1);
        }

        long result = 0;
        for (int i = 0; i < 5; i++) {
            result = (result + solve_DP(i, n - 1)) % M;
        }

        return (int) result;
    }

    // recursion.
    private static long solve(int ch, int len) {
        if (len == 0) {
            return 1;
        }

        long result = 0;
        if (ch == a) {
            result = (result + solve(e, len - 1)) % M;
        }

        else if (ch == e) {
            result = (result + solve(a, len - 1)) % M;
            result = (result + solve(i, len - 1)) % M;
        }

        else if (ch == i) {
            result = (result + solve(a, len - 1)) % M;
            result = (result + solve(e, len - 1)) % M;
            result = (result + solve(o, len - 1)) % M;
            result = (result + solve(u, len - 1)) % M;
        }

        else if (ch == o) {
            result = (result + solve(i, len - 1)) % M;
            result = (result + solve(u, len - 1)) % M;
        }

        else if (ch == u) {
            result = (result + solve(a, len - 1)) % M;
        }

        return result;
    }

    // using DP.
    private static long solve_DP(int ch, int len) {
        if (len == 0) {
            return 1;
        }

        if (dp[ch][len] != -1) {
            return dp[ch][len];
        }

        long result = 0;
        if (ch == a) {
            result = (result + solve_DP(e, len - 1)) % M;
        }

        else if (ch == e) {
            result = (result + solve_DP(a, len - 1)) % M;
            result = (result + solve_DP(i, len - 1)) % M;
        }

        else if (ch == i) {
            result = (result + solve_DP(a, len - 1)) % M;
            result = (result + solve_DP(e, len - 1)) % M;
            result = (result + solve_DP(o, len - 1)) % M;
            result = (result + solve_DP(u, len - 1)) % M;
        }

        else if (ch == o) {
            result = (result + solve_DP(i, len - 1)) % M;
            result = (result + solve_DP(u, len - 1)) % M;
        }

        else if (ch == u) {
            result = (result + solve_DP(a, len - 1)) % M;
        }

        return dp[ch][len] = result;
    }
}
