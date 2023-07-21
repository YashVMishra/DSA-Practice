//https://leetcode.com/problems/as-far-from-land-as-possible/description/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class As_Far_From_Land {
    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println(maxDistance(grid));
    }

    public static int maxDistance(int[][] grid) {

        // used to store the visited cells.
        Set<String> visited = new HashSet<>();

        // to implement BFS
        Queue<int[]> queue = new LinkedList<>();

        // for BFS traversal.
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // we will check only for cells which have 1.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    queue.offer(arr);
                    visited.add(i + "|" + j);
                }
            }
        }

        // BFS logic
        int stepsTaken = -1;
        while (!queue.isEmpty()) {

            // incrementing stepstaken when we enter new level.
            stepsTaken++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] index = queue.poll();
                int x = index[0];
                int y = index[1];

                for (int j = 0; j < 4; j++) {
                    int newX = x + directions[j][0];
                    int newY = y + directions[j][1];

                    if (!isValid(newX, newY, grid)) {
                        continue;
                    }

                    if (visited.contains(newX + "|" + newY)) {
                        continue;
                    }

                    int[] temp = new int[2];
                    temp[0] = newX;
                    temp[1] = newY;
                    queue.offer(temp);
                    visited.add(newX + "|" + newY);
                }
            }
        }

        return stepsTaken == 0 ? -1 : stepsTaken;
    }

    // function to check for valid x and y.
    public static boolean isValid(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length) {
            return false;
        }

        if (y < 0 || y >= grid[0].length) {
            return false;
        }

        return grid[x][y] == 0;
    }

}