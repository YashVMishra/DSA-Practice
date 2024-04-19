// https://leetcode.com/problems/island-perimeter/description/?envType=daily-question&envId=2024-04-18

import java.util.LinkedList;
import java.util.Queue;

public class Island_Perimeter {
    static int m;
    static int n;
    static int peri;
    static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

        System.out.println(islandPerimeter(grid));
        System.out.println(islandPerimeter_2(grid));
        System.out.println(islandPerimeter_3(grid));
    }

    private static int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        peri = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return peri;
                }
            }
        }

        return -1;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            peri++;
            return;
        }

        if (grid[i][j] == -1) {
            return;
        }

        grid[i][j] = -1; // mark visited

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    // ------------------------------------------------------------------------------------------------------------------

    private static int islandPerimeter_2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return bfs(grid, i, j);
                }
            }
        }

        return -1;
    }

    private static int bfs(int[][] grid, int i, int j) {
        int perim = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        grid[i][j] = -1;

        while (!queue.isEmpty()) {
            int[] it = queue.poll();

            for (int[] dir : directions) {
                int i_ = it[0] + dir[0];
                int j_ = it[1] + dir[1];

                if (i_ < 0 || i_ >= m || j_ < 0 || j_ >= n || grid[i_][j_] == 0)
                    perim++;
                else if (grid[i_][j_] == -1)
                    continue;
                else {
                    queue.offer(new int[] { i_, j_ });
                    grid[i_][j_] = -1;
                }
            }
        }

        return perim;
    }

    // ------------------------------------------------------------------------------------------------------------------

    public static int islandPerimeter_3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;

                if (i - 1 < 0 || grid[i - 1][j] == 0) // up
                    perimeter++;

                if (i + 1 >= m || grid[i + 1][j] == 0) // down
                    perimeter++;

                if (j - 1 < 0 || grid[i][j - 1] == 0) // left
                    perimeter++;

                if (j + 1 >= n || grid[i][j + 1] == 0) // right
                    perimeter++;
            }
        }

        return perimeter;
    }
}
