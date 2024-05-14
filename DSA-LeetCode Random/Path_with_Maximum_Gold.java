// https://leetcode.com/problems/path-with-maximum-gold/description/

public class Path_with_Maximum_Gold {
    private static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        int[][] grid = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
        System.out.println(getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) {
            return 0;
        }

        int originalValue = grid[i][j];
        grid[i][j] = 0;
        int localMax = 0;

        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            localMax = Math.max(localMax, dfs(grid, x, y));
        }

        grid[i][j] = originalValue;
        return originalValue + localMax;
    }
}
