//https://leetcode.com/problems/shortest-bridge/description/

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Bridge {
    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 } };
        System.out.println(shortestBridge(grid));
    }

    private static void dfs(int[][] A, boolean[][] visited, Queue<int[]> q, int i, int j, int[][] dirs) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        q.offer(new int[] { i, j });

        for (int[] dir : dirs) {
            dfs(A, visited, q, i + dir[0], j + dir[1], dirs);
        }

    }

    public static int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, visited, q, i, j, dirs);
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }

        }

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                for (int[] dir : dirs) {
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];

                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
                        if (A[i][j] == 1) {
                            return step;
                        }

                        q.offer(new int[] { i, j });
                        visited[i][j] = true;
                    }
                }
            }

            step++;
        }

        return -1;
    }
}
