// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/description/?envType=daily-question&envId=2023-12-29

import java.util.Arrays;

public class Minimum_Difficulty_of_a_Job_Schedule {
    private static int[][] t;

    public static void main(String[] args) {
        System.out.println(minDifficulty(new int[] { 6, 5, 4, 3, 2, 1 }, 2));
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d)
            return -1;

        t = new int[n][d + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(jobDifficulty, n, 0, d);
    }

    private static int solve(int[] jobDifficulty, int n, int idx, int d) {
        // If you have only 1 day, then you will do all the remaining jobs
        // and select the max difficulty as the answer
        if (d == 1) {
            return Arrays.stream(Arrays.copyOfRange(jobDifficulty, idx, n)).max().orElse(Integer.MIN_VALUE);
        }

        if (t[idx][d] != -1)
            return t[idx][d];

        int maxDifficulty = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;

        // Try one by one with all possibilities
        /*
         * Take 1 job in one day Take 2 jobs in one day Take 3 jobs in one day and so
         * on Then find the optimal one among all the results
         */
        for (int i = idx; i <= n - d; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            result = Math.min(result, maxDifficulty + solve(jobDifficulty, n, i + 1, d - 1));
        }

        return t[idx][d] = result;
    }
}
