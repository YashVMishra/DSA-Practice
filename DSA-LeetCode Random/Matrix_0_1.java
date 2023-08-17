// https://leetcode.com/problems/01-matrix/description/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int first;
    int second;
    int third;

    Node(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class Matrix_0_1 {
    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        int[][] visited = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        while (!q.isEmpty()) {
            int x = q.peek().first;
            int y = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            ans[x][y] = steps;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0) {
                    q.add(new Node(nx, ny, steps + 1));
                    visited[nx][ny] = 1;
                }
            }
        }

        return ans;
    }
}
