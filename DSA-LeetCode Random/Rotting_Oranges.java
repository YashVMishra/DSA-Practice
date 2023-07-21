//https://leetcode.com/problems/rotting-oranges/description/?envType=study-plan&id=level-2

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class Rotting_Oranges {
    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[row][col];
        int count_fresh = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }

                else {
                    visited[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        int req_time = 0;

        // delta row and delta column
        int drow[] = { -1, 0, +1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        int curr_fresh = 0;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            req_time = Math.max(req_time, t);
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                // check for valid coordinates and
                // then for unvisited fresh orange
                if (nrow >= 0 && nrow < row && ncol >= 0 && ncol < col && visited[nrow][ncol] == 0
                        && grid[nrow][ncol] == 1) {

                    // push in queue with timer increased
                    q.add(new Pair(nrow, ncol, t + 1));

                    // mark as rotten
                    visited[nrow][ncol] = 2;
                    curr_fresh++;
                }
            }
        }

        if (curr_fresh != count_fresh) {
            return -1;
        }

        return req_time;
    }

}
