import java.util.Arrays;
import java.util.HashSet;

public class Difference_of_Number_of_Distinct_Values_on_Diagonals {
    public static void main(String[] args) {
        int[][] grid = { { 1 } };
        System.out.println(Arrays.deepToString(differenceOfDistinctValues(grid)));
    }

    public static int[][] differenceOfDistinctValues(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] ans = new int[row][col];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = solve(grid, i, j, set);
            }
        }

        return ans;
    }

    public static int solve(int[][] grid, int row, int col, HashSet<Integer> set) {
        int i = row - 1;
        int j = col - 1;

        // top-left
        while (i >= 0 && j >= 0) {
            set.add(grid[i][j]);
            i--;
            j--;
        }

        int topLeft = set.size();
        set.clear();

        i = row + 1;
        j = col + 1;

        // bottom-right
        while (i < grid.length && j < grid[0].length) {
            set.add(grid[i][j]);
            i++;
            j++;
        }

        int bottomRight = set.size();
        set.clear();

        return Math.abs(topLeft - bottomRight);
    }
}
