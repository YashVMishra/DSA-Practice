// https://leetcode.com/problems/longest-string-chain/description/?envType=daily-question&envId=2023-09-23

import java.util.Arrays;

public class Longest_String_Chain {
    public static void main(String[] args) {
        String[] words = { "abcd", "abxcd", "a", "ab", "abc" };
        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        int[][] dp = new int[words.length + 1][words.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        return LIS_Variant_DP(words, -1, 0, dp);
    }

    // recursion.
    private static int LIS_Variant(String[] words, int prevIndex, int index) {
        if (index == words.length) {
            return 0;
        }

        int take = 0;
        int notTake = 0;

        // taking the current word.
        // always write prevIndex == -1 first because of short circuiting.
        if (prevIndex == -1 || isPredecessor(words[prevIndex], words[index])) {
            take = 1 + LIS_Variant(words, index, index + 1);
        }

        // skipping the current word.
        notTake = LIS_Variant(words, prevIndex, index + 1);

        return Math.max(take, notTake);
    }

    // DP
    private static int LIS_Variant_DP(String[] words, int prevIndex, int index, int[][] dp) {
        if (index == words.length) {
            return 0;
        }

        if (dp[prevIndex + 1][index] != -1) {
            return dp[prevIndex + 1][index];
        }

        int take = 0;
        int notTake = 0;

        // take the current word.
        // always write prevIndex == -1 first because of short circuiting.
        if (prevIndex == -1 || isPredecessor(words[prevIndex], words[index])) {
            take = 1 + LIS_Variant_DP(words, index, index + 1, dp);
        }

        // skipping the current word.
        notTake = LIS_Variant_DP(words, prevIndex, index + 1, dp);

        // prevIndex + 1 because prevIndex can be -1.
        return dp[prevIndex + 1][index] = Math.max(take, notTake);
    }

    // predecessor function.
    private static boolean isPredecessor(String str1, String str2) {
        if (str1.length() + 1 != str2.length()) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == str1.length();
    }
}
