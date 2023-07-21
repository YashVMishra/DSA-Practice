//https://leetcode.com/problems/where-will-the-ball-fall/description/?envType=study-plan&id=level-2

import java.util.Arrays;

public class Where_Will_the_Ball_Fall {
    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1, -1, -1 }, { 1, 1, 1, -1, -1 }, { -1, -1, -1, 1, 1 }, { 1, 1, 1, 1, -1 },
                { -1, -1, -1, -1, -1 } };
        System.out.println(Arrays.toString(findBall(grid)));
    }

    public static int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[] ans = new int[col];

        for (int j = 0; j < col; j++) {
            int curr_pos = j;
            int next_pos = -1;

            for (int i = 0; i < row; i++) {
                next_pos = curr_pos + grid[i][curr_pos];

                if (next_pos < 0 || next_pos >= col || grid[i][curr_pos] != grid[i][next_pos]) {
                    curr_pos = -1;
                    break;
                }

                curr_pos = next_pos;
            }

            ans[j] = curr_pos;
        }

        return ans;
    }
}
