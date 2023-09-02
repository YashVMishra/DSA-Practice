// https://leetcode.com/problems/extra-characters-in-a-string/description/?envType=daily-question&envId=2023-09-02

import java.util.Arrays;
import java.util.HashSet;

public class Extra_Characters_in_a_String {
    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = { "leet", "code", "leetcode" };
        System.out.println(minExtraChar(s, dictionary));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for (String str : dictionary) {
            set.add(str);
        }

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return helper_DP(0, set, s, dp);
    }

    // recursion.
    private static int helper(int index, HashSet<String> set, String s) {
        if (index >= s.length()) {
            return 0;
        }

        int minExtra = s.length();
        String currString = "";

        for (int i = index; i < s.length(); i++) {
            currString += s.charAt(i);

            int currExtra = set.contains(currString) ? 0 : currString.length();

            int remainingExtra = helper(i + 1, set, s);
            int totalExtra = currExtra + remainingExtra;

            minExtra = Math.min(totalExtra, minExtra);
        }

        return minExtra;
    }

    // DP
    private static int helper_DP(int index, HashSet<String> set, String s, int[] dp) {
        if (index >= s.length()) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // maximum extra characters in a string can be the length of the string.
        int minExtra = s.length();
        String currString = "";

        for (int i = index; i < s.length(); i++) {
            currString += s.charAt(i);

            // if set contains the currString then we will add 0 extra characters.
            // else we add the lenght of the current currString.
            int currExtra = set.contains(currString) ? 0 : currString.length();

            // returns the remaining extra from the next index.
            int remainingExtra = helper_DP(i + 1, set, s, dp);
            int totalExtra = currExtra + remainingExtra;

            minExtra = Math.min(totalExtra, minExtra);
        }

        dp[index] = minExtra;
        return minExtra;
    }
}
