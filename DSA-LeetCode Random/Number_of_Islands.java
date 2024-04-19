// https://leetcode.com/problems/number-of-islands/description/?envType=daily-question&envId=2024-04-19

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Islands {
    private static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        System.out.println(numIslands(grid));
        System.out.println(numIslands_2(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '$';

        for (int[] p : dir) {
            int i_ = i + p[0];
            int j_ = j + p[1];
            dfs(grid, i_, j_);
        }
    }

    // ------------------------------------------------------------------------------------------------------------------

    public static int numIslands_2(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    bfs(grid, i, j, que);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, int i, int j, Queue<int[]> que) {
        que.offer(new int[] { i, j });
        grid[i][j] = '$';

        while (!que.isEmpty()) {
            int[] curr = que.poll();

            for (int[] p : dir) {
                int i_ = curr[0] + p[0];
                int j_ = curr[1] + p[1];

                if (isSafe(grid, i_, j_)) {
                    que.offer(new int[] { i_, j_ });
                    grid[i_][j_] = '$';
                }
            }
        }
    }

    private static boolean isSafe(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1';
    }
}
