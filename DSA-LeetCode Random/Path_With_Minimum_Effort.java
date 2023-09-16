// https://leetcode.com/problems/path-with-minimum-effort/description/?envType=daily-question&envId=2023-09-16

import java.util.*;

class Pair {
    int first;
    int[] second;

    public Pair(int first, int[] second) {
        this.first = first;
        this.second = second;
    }
}

public class Path_With_Minimum_Effort {
    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };

        System.out.println(new Path_With_Minimum_Effort().minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        int[][] directions = {
                { -1, 0 },
                { 0, -1 },
                { 0, 1 },
                { 1, 0 }
        };

        pq.offer(new Pair(0, new int[] { 0, 0 }));
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int diff = top.first;
            int x = top.second[0];
            int y = top.second[1];

            if (x == m - 1 && y == n - 1) {
                return diff;
            }

            for (int[] dir : directions) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if (x_ >= 0 && x_ < m && y_ >= 0 && y_ < n) {
                    int newDiff = Math.max(diff, Math.abs(heights[x][y] - heights[x_][y_]));
                    if (result[x_][y_] > newDiff) {
                        result[x_][y_] = newDiff;
                        pq.offer(new Pair(result[x_][y_], new int[] { x_, y_ }));
                    }
                }
            }
        }

        return result[m - 1][n - 1];
    }
}
