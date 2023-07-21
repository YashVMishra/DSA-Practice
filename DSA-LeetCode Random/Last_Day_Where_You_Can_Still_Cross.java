//https://leetcode.com/problems/last-day-where-you-can-still-cross/description/

import java.util.LinkedList;
import java.util.Queue;

class Pair<T, U> {
    T first;
    U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

public class Last_Day_Where_You_Can_Still_Cross {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        int row = 2, col = 2;
        int[][] cells = { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 2, 2 } };
        System.out.println(latestDayToCross(row, col, cells));
    }

    public static int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = cells.length;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canWalk(cells, row, col, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static boolean canWalk(int[][] cells, int row, int col, int dayAt) {
        boolean[][] grid = new boolean[row][col];
        for (int i = 0; i < dayAt; ++i) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = true;
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int c = 0; c < col; ++c) {
            if (!grid[0][c]) {
                q.add(new Pair<>(0, c));
                grid[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            Pair<Integer, Integer> pair = q.poll();
            int r = pair.first;
            int c = pair.second;

            if (r == row - 1) {
                return true;
            }

            for (int i = 0; i < 4; ++i) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nr == row || nc < 0 || nc == col || grid[nr][nc]) {
                    continue;
                }

                grid[nr][nc] = true;
                q.add(new Pair<>(nr, nc));
            }
        }

        return false;
    }
}
