import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-enclaves/description/

public class Number_Of_Enclaves {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
        System.out.println(numEnclaves_2(grid));
        System.out.println(numEnclaves(grid));
    }

    // just convert all the 1 connecting with the boundary to 0
    // and then count the number of 1 present in the grid.
    // used DFS.
    // changes the original data.
    public static int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i * j == 0 || i == m - 1 || j == n - 1) && (grid[i][j] == 1))
                    dfs(i, j, grid);
            }
        }

        int ans = 0;
        for (int[] arr : grid) {
            for (int i : arr) {
                if (i == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // converting boundary 1 to 0.
    public static void dfs(int i, int j, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            dfs(nx, ny, grid);
        }
    }

    // using multi-source BFS
    // not changing the data.
    public static int numEnclaves_2(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || j == n - 1 || i == m - 1) && grid[i][j] == 1) {
                    q.add(new int[] { i, j });
                    vis[i][j] = 1;
                }
            }
        }

        int delRow[] = { -1, 0, +1, 0 };
        int delCol[] = { 0, +1, +0, -1 };

        while (!q.isEmpty()) {
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.remove();

            // doing multisource BFS.
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = 1;
                    q.add(new int[] { nrow, ncol });
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
