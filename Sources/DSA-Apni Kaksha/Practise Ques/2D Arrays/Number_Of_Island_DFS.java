//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.LinkedList;
import java.util.Queue;

//before pasting this code anywhere please check the datatype of the input array that is
//whether it is char or String.
public class Number_Of_Island_DFS {
    public static void main(String[] args) {
        System.out.println(numberOfIslands(new String[][] { { "1", "1", "0", "0", "0" },
                { "1", "1", "0", "0", "0" },
                { "0", "0", "1", "0", "0" },
                { "0", "0", "0", "1", "1" }
        }));

    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int numberOfIslands(String[][] nums) {
        int row = nums.length;
        int col = nums[0].length;

        int[][] visited = new int[row][col];

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 0 && nums[i][j] == "1") {
                    count++;
                    bfs_4_dr(visited, i, j, nums);
                }
            }
        }

        return count;
    }

    //// this bfs is for eight directions that is up, down, right, left and the
    //// diagonals.
    public static void bfs(int[][] visited, int row, int col, String[][] nums) {
        visited[row][col] = 1;

        Queue<Pair> qu = new LinkedList<Pair>();
        qu.add(new Pair(row, col));

        while (!qu.isEmpty()) {
            int ro = qu.peek().first;
            int co = qu.peek().second;
            qu.remove();

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nrow = ro + i;
                    int ncol = co + j;

                    if (nrow >= 0 && ncol >= 0 && nrow < nums.length && ncol < nums[0].length
                            && visited[nrow][ncol] == 0 && nums[nrow][ncol] == "1") {
                        visited[nrow][ncol] = 1;
                        qu.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    // this bfs is for four directions that is up, down, right and left
    public static void bfs_4_dr(int[][] visited, int row, int col, String[][] nums) {
        visited[row][col] = 1;

        Queue<Pair> qu = new LinkedList<Pair>();
        qu.add(new Pair(row, col));

        while (!qu.isEmpty()) {
            int nrow = qu.peek().first;
            int ncol = qu.peek().second;
            qu.remove();

            if (nrow + 1 >= 0 && ncol >= 0 && nrow + 1 < nums.length && ncol < nums[0].length
                    && visited[nrow + 1][ncol] == 0 && nums[nrow + 1][ncol] == "1") {
                visited[nrow + 1][ncol] = 1;
                qu.add(new Pair(nrow + 1, ncol));
            }

            if (nrow - 1 >= 0 && ncol >= 0 && nrow - 1 < nums.length && ncol < nums[0].length
                    && visited[nrow - 1][ncol] == 0 && nums[nrow - 1][ncol] == "1") {
                visited[nrow - 1][ncol] = 1;
                qu.add(new Pair(nrow - 1, ncol));
            }

            if (nrow >= 0 && ncol + 1 >= 0 && nrow < nums.length && ncol + 1 < nums[0].length
                    && visited[nrow][ncol + 1] == 0 && nums[nrow][ncol + 1] == "1") {
                visited[nrow][ncol + 1] = 1;
                qu.add(new Pair(nrow, ncol + 1));
            }

            if (nrow >= 0 && ncol - 1 >= 0 && nrow < nums.length && ncol - 1 < nums[0].length
                    && visited[nrow][ncol - 1] == 0 && nums[nrow][ncol - 1] == "1") {
                visited[nrow][ncol - 1] = 1;
                qu.add(new Pair(nrow, ncol - 1));
            }

        }
    }
}
