// https://leetcode.com/problems/non-overlapping-intervals/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        // we have taken ans as -1 as at first we have taken previous as intervals[0].
        // if you take ans as 0 then start from second row of the interval array.
        int ans = -1;

        // sorting acc to end time.
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int[] prev = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] >= prev[1]) {
                prev = interval;
            } else {
                ans++;
            }
        }

        return ans;
    }
}
