// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Nearest_Exit_from_Entrance_in_Maze {

    private static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        char[][] maze = { { '+', '+', '+', '+', '+', '+' }, { '+', '.', '.', '.', '.', '+' },
                { '+', '.', '+', '+', '+', '+' }, { '+', '.', '+', '+', '+', '+' }, { '+', '.', '.', '.', '.', '+' },
                { '+', '+', '+', '+', '+', '+' } };
        int[] entrance = { 0, 1 };
        System.out.println(nearestExit(maze, entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+'; // marking it visited
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();

                if (!Arrays.equals(temp, entrance) &&
                        (temp[0] == 0 || temp[0] == m - 1 || temp[1] == 0 || temp[1] == n - 1))
                    return steps;

                for (int[] dir : directions) {
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != '+') {
                        queue.offer(new int[] { x, y });
                        maze[x][y] = '+'; // marking it as visited
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
