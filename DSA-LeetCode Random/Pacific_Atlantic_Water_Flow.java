//https://leetcode.com/problems/pacific-atlantic-water-flow/description/?envType=study-plan&id=level-2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {
    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return ans;
        }

        int row = heights.length;
        int col = heights[0].length;
        boolean[][] atlantic = new boolean[row][col];
        boolean[][] pacific = new boolean[row][col];

        // DFS calling.
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atlantic);
        }

        // DFS calling.
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlantic);
        }

        // preparing the answer.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public static void dfs(int[][] heights, int row, int col, int previous, boolean[][] ocean) {
        if (row < 0 || row >= ocean.length || col < 0 || col >= ocean[0].length) {
            return;
        }

        if (heights[row][col] < previous || ocean[row][col]) {
            return;
        }

        ocean[row][col] = true;

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int[] d : dir) {
            dfs(heights, row + d[0], col + d[1], heights[row][col], ocean);
        }
    }
}
