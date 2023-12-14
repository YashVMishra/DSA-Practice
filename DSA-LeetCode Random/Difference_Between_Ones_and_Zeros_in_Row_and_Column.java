// https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/?envType=daily-question&envId=2023-12-14

import java.util.Arrays;

class Pair {
    int one;
    int zero;

    Pair(int one, int zero) {
        this.one = one;
        this.zero = zero;
    }
}

public class Difference_Between_Ones_and_Zeros_in_Row_and_Column {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1 }, { 1, 0, 1 }, { 0, 0, 1 } };
        int[][] ans = onesMinusZeros(grid);

        System.out.println(Arrays.deepToString(ans));
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        Pair[] rows = new Pair[grid.length];
        Pair[] cols = new Pair[grid[0].length];
        int[][] ans = new int[grid.length][grid[0].length];

        // counting the number of 1 and 0 in each row.
        for (int i = 0; i < grid.length; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    one++;
                } else {
                    zero++;
                }
            }

            rows[i] = new Pair(one, zero);
        }

        // counting the number of 1 and 0 in each col.
        for (int j = 0; j < grid[0].length; j++) {
            int one = 0;
            int zero = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    one++;
                } else {
                    zero++;
                }
            }

            cols[j] = new Pair(one, zero);
        }

        // calculating the difference between 1 and 0 in each row and col.
        // and storing it in the ans array.
        for (int i = 0; i < rows.length; i++) {
            Pair row = rows[i];
            for (int j = 0; j < cols.length; j++) {
                Pair col = cols[j];
                ans[i][j] = row.one - row.zero + col.one - col.zero;
            }
        }

        return ans;
    }

    // -----------------------------------------------------------------------------------

    public int[][] onesMinusZeros_2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowOnes[i]++;
                    colOnes[j]++;
                }
            }
        }

        int[][] diff = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int onesRowi = rowOnes[i];
                int onesColj = colOnes[j];

                // pay attention to what we are subtracting from
                // dry run for better understanding.
                int zerosRowi = n - onesRowi;
                int zerosColj = m - onesColj;

                diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj;
            }
        }

        return diff;
    }
}