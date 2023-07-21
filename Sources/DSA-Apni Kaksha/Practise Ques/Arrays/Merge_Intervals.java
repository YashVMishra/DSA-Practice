//https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1
//https://leetcode.com/problems/merge-intervals/description/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Merge_Intervals {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(merge(new int[][] { { 1, 3 }, { 2, 4 }, {
        // 6, 8 }, { 9, 10 } })));
        int[][] arr = merge(new int[][] { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } });

        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] merge(int[][] arr) {
        List<int[]> ans = new ArrayList<>();

        if (arr.length == 0 || arr == null) {
            return ans.toArray(new int[0][]);
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int start = arr[0][0];
        int end = arr[0][1];

        for (int[] i : arr) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            }

            else {
                ans.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }
        }

        ans.add(new int[] { start, end });
        return ans.toArray(new int[0][]);

    }
}
