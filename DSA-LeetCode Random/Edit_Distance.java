// https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class Edit_Distance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        // return solve(word1, word2, 0, 0);

        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve_DP(word1, word2, 0, 0, memo);
    }

    // using recursion.
    private static int solve(String word1, String word2, int i, int j) {
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = solve(word1, word2, i + 1, j + 1);
        } else {
            int insert = 1 + solve(word1, word2, i, j + 1);
            int delete = 1 + solve(word1, word2, i + 1, j);
            int replace = 1 + solve(word1, word2, i + 1, j + 1);

            ans = Math.min(insert, Math.min(delete, replace));
        }

        return ans;
    }

    // using DP
    private static int solve_DP(String word1, String word2, int i, int j, int[][] memo) {
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = solve_DP(word1, word2, i + 1, j + 1, memo);
        } else {
            int insert = 1 + solve_DP(word1, word2, i, j + 1, memo);
            int delete = 1 + solve_DP(word1, word2, i + 1, j, memo);
            int replace = 1 + solve_DP(word1, word2, i + 1, j + 1, memo);

            ans = Math.min(insert, Math.min(delete, replace));
        }

        memo[i][j] = ans;
        return ans;
    }
}
