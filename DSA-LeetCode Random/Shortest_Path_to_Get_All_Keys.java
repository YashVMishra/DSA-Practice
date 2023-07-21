//https://leetcode.com/problems/shortest-path-to-get-all-keys/description/

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Shortest_Path_to_Get_All_Keys {
    public static void main(String[] args) {
        String[] grid = { "@.a..", "###.#", "b.A.B" };
        System.out.println(shortestPathAllKeys(grid));
    }

    public static int shortestPathAllKeys(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max_len = -1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                char c = grid[i].charAt(j);

                if (c == '@') {
                    x = i;
                    y = j;
                }

                if (c >= 'a' && c <= 'f') {
                    max_len = Math.max(c - 'a' + 1, max_len);
                }
            }
        }

        int[] start = { 0, x, y };
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(start));
        q.offer(start);
        int step = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; ++k) {
                int[] curr = q.poll();

                if (curr[0] == (1 << max_len) - 1)
                    return step;

                for (int[] d : dirs) {
                    int i = curr[1] + d[0];
                    int j = curr[2] + d[1];
                    int keys = curr[0];

                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char c = grid[i].charAt(j);

                        if (c == '#')
                            continue;

                        if (c >= 'a' && c <= 'f')
                            keys |= 1 << (c - 'a');

                        if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0)
                            continue;

                        if (!visited.contains(Arrays.toString(new int[] { keys, i, j }))) {
                            visited.add(Arrays.toString(new int[] { keys, i, j }));
                            q.offer(new int[] { keys, i, j });
                        }
                    }
                }
            }

            ++step;
        }

        return -1;
    }
}
