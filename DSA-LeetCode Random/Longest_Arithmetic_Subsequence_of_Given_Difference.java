//https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/

import java.util.HashMap;

public class Longest_Arithmetic_Subsequence_of_Given_Difference {
    public static void main(String[] args) {
        int difference = 1;
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(longestSubsequence(arr, difference));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int LAS = 1;

        for (int i : arr) {
            int beforeI = dp.getOrDefault(i - difference, 0);
            dp.put(i, beforeI + 1);
            LAS = Math.max(LAS, dp.get(i));
        }

        return LAS;
    }
}
