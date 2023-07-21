//https://leetcode.com/problems/solving-questions-with-brainpower/description/

import java.util.Arrays;

public class Solving_Questions_With_Brainpower {
    public static void main(String[] args) {
        int[][] questions = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } };
        System.out.println(mostPoints(questions));
    }

    // its simple just start with the first index, first take it and then not take
    // it
    // that is find the result when the first element is taken and same as when we
    // do not
    // take the element.
    // if you take the element that make sure to update the index by the given
    // brainpower value/
    // if not take the element that make sure to update the index by 1;
    // and at last just return the maximum of the two.

    public static long mostPoints(int[][] questions) {
        // return solve(questions, 0);
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);

        return solve_DP(questions, 0, dp);
    }

    // using recursion
    // shows TLE.
    public static long solve(int[][] questions, int index) {
        if (index >= questions.length) {
            return 0;
        }

        long taken = questions[index][0] + solve(questions, index + questions[index][1] + 1);
        long notTaken = 0 + solve(questions, index + 1);

        return Math.max(taken, notTaken);
    }

    // using DP
    public static long solve_DP(int[][] questions, int index, long[] dp) {
        if (index >= questions.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        long taken = questions[index][0] + solve_DP(questions, index + questions[index][1] + 1, dp);
        long notTaken = 0 + solve_DP(questions, index + 1, dp);

        dp[index] = Math.max(taken, notTaken);

        return dp[index];
    }
}
