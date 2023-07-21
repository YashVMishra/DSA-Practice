//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix {
    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        // if the starting element is 1 we cannot enter the grid.
        if (grid[0][0] == 1) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 1 });
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                int[] point = queue.poll();

                if (point[0] == row - 1 && point[1] == col - 1) {
                    return point[2];
                }

                for (int[] d : dir) {
                    int nrow = point[0] + d[0];
                    int ncol = point[1] + d[1];

                    if (nrow >= 0 && nrow < row && ncol >= 0 && ncol < col && grid[nrow][ncol] == 0) {
                        queue.add(new int[] { nrow, ncol, point[2] + 1 });
                        grid[nrow][ncol] = 1;
                    }
                }

                size--;
            }
        }

        return -1;
    }
}
