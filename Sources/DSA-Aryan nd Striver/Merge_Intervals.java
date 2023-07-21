//https://leetcode.com/problems/merge-intervals/description/

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_Intervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] arr) {
        ArrayList<int[]> ans = new ArrayList<>();

        if (arr.length == 0) {
            return ans.toArray(new int[0][]);
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int start = arr[0][0];
        int end = arr[0][1];

        for (int[] temp : arr) {
            if (temp[0] <= end) {
                end = Math.max(end, temp[1]);
            } else {
                ans.add(new int[] { start, end });
                start = temp[0];
                end = temp[1];
            }
        }

        ans.add(new int[] { start, end });
        return ans.toArray(new int[ans.size()][]);
    }
}
