//https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/

public class Number_of_Increasing_Paths_in_a_Grid {

    static int mod = 1000000007;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        int[][] grid = { { 1, 1 }, { 3, 4 } };
        System.out.println(countPaths(grid));
    }

    public static int countPaths(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        long count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count = (count % mod + dfs(i, j, grid, dp) % mod) % mod;
            }
        }

        return (int) count % mod;
    }

    public static boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public static int dfs(int x, int y, int[][] grid, int[][] dp) {
        if (dp[x][y] != -1)
            return dp[x][y];
        int ans = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (isValid(nx, ny, grid) && grid[x][y] < grid[nx][ny]) {
                ans = (ans % mod + dfs(nx, ny, grid, dp) % mod) % mod;
            }
        }
        return dp[x][y] = ans % mod;
    }
}
