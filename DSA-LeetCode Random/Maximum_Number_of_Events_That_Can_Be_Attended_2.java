//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/

// You can further optimize the code in the both the helper functions
// by replacing the for loop with binary search as events array is sorted.

import java.util.Arrays;
import java.util.Comparator;

public class Maximum_Number_of_Events_That_Can_Be_Attended_2 {
    public static void main(String[] args) {
        int[][] events = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
        int k = 2;

        System.out.println(maxValue(events, k));
    }

    public static int maxValue(int[][] events, int k) {

        // sorting according to startday.
        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {

                // to do in descending order revert the '>' sign.
                if (a[0] > b[0]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int[][] dp = new int[events.length + 1][k + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return helper_2(events, k, 0, dp);
    }

    // using recursion.
    public static int helper(int[][] events, int k, int position) {
        if (position >= events.length || k == 0) {
            return 0;
        }

        int i;
        for (i = position + 1; i < events.length; i++) {
            if (events[i][0] > events[position][1]) {
                break;
            }
        }

        int take = helper(events, k - 1, i) + events[position][2];
        int notTake = helper(events, k, position + 1);

        return Math.max(take, notTake);
    }

    // using DP.
    public static int helper_2(int[][] events, int k, int position, int[][] dp) {
        if (position >= events.length || k == 0) {
            return 0;
        }

        if (dp[position][k] != -1) {
            return dp[position][k];
        }

        int i;
        for (i = position + 1; i < events.length; i++) {
            if (events[i][0] > events[position][1]) {
                break;
            }
        }

        int take = helper_2(events, k - 1, i, dp) + events[position][2];
        int notTake = helper_2(events, k, position + 1, dp);

        dp[position][k] = Math.max(take, notTake);
        return dp[position][k];
    }
}
