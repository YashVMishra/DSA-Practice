//https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.Arrays;

public class Replace_O_with_X {
    public static void main(String[] args) {
        char[][] arr = { { 'X', 'X', 'X', 'X', 'X' },
                { 'O', 'X', 'X', 'X', 'O' },
                { 'O', 'X', 'X', 'O', 'X' },
                { 'X', 'X', 'X', 'O', 'O' },
        };

        System.out.println(Arrays.deepToString(fill(arr.length, arr[0].length, arr)));
    }

    static char[][] fill(int n, int m, char mat[][]) {
        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, 1, 0, -1 };
        int vis[][] = new int[n][m];
        // traverse first row and last row
        for (int j = 0; j < m; j++) {
            // check for unvisited Os in the boundary rws
            // first row
            if (vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delrow, delcol);
            }

            // last row
            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            // check for unvisited Os in the boundary columns
            // first column
            if (vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delrow, delcol);
            }

            // last column
            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, delrow, delcol);
            }
        }

        // if unvisited O then convert to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O')
                    mat[i][j] = 'X';
            }
        }

        return mat;
    }

    static void dfs(int row, int col, int vis[][],
            char mat[][], int delrow[], int delcol[]) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;

        // check for top, right, bottom, left
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            // check for valid coordinates and unvisited Os
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    }
}
