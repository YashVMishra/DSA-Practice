// https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/?envType=daily-question&envId=2024-01-06

import java.util.Arrays;

public class Maximum_Profit_in_Job_Scheduling {
    static int[] memo = new int[5001];

    public static void main(String[] args) {
        int[] startTime = { 1, 2, 3, 3 };
        int[] endTime = { 3, 4, 5, 6 };
        int[] profit = { 50, 10, 40, 70 };

        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];

        for (int i = 0; i < startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.fill(memo, -1);

        return solve(jobs, 0);
    }

    private static int solve(int[][] jobs, int i) {
        if (i >= jobs.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int nextIndex = nextJobIndex(jobs, i + 1, jobs[i][1]);

        int include = jobs[i][2] + solve(jobs, nextIndex);
        int exclude = solve(jobs, i + 1);

        return memo[i] = Math.max(include, exclude);
    }

    private static int nextJobIndex(int[][] jobs, int left, int endTime) {
        int right = jobs.length - 1;
        int ans = jobs.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (jobs[mid][0] >= endTime) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
