// https://leetcode.com/problems/out-of-boundary-paths/description/?envType=daily-question&envId=2024-01-26

import java.util.Arrays;

public class Out_of_Boundary_Paths {
    static int M;
    static int N;
    static int MOD = (int) 1e9 + 7;
    static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static private int[][][] t;

    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        t = new int[maxMove + 1][m][n];
        for (int i = 0; i <= maxMove; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }

        M = m;
        N = n;
        return solve(maxMove, startRow, startColumn);
    }

    private static int solve(int maxMove, int startRow, int startColumn) {
        if (startRow < 0 || startRow >= M || startColumn < 0 || startColumn >= N) {
            return 1; // Found one path out
        }

        if (maxMove <= 0) {
            return 0;
        }

        if (t[maxMove][startRow][startColumn] != -1) {
            return t[maxMove][startRow][startColumn];
        }

        int result = 0;
        for (int[] dir : directions) {
            int x = startRow + dir[0];
            int y = startColumn + dir[1];

            result = (result + solve(maxMove - 1, x, y)) % MOD;
        }

        return t[maxMove][startRow][startColumn] = result % MOD;
    }
}