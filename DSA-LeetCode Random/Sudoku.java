//https://leetcode.com/problems/sudoku-solver/description/

public class Sudoku {
    public static void main(String[] args) {
        int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        solve(grid);
        // System.out.println(Arrays.deepToString(grid));
        print(grid);
    }

    public static boolean solve(int[][] grid) {
        int len = grid.length;

        // -1 so that each time we can find the new row and col
        int row = -1;
        int col = -1;

        // to check for the empty places
        boolean isEmpty = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;

                    // whenever you find the empty space , mark its row and col
                    isEmpty = false;
                    break;
                }
            }

            // if you come out of the inner loop and the isEmpty is false then you
            // have find the empty space and if its true then the inner loop
            // has run its entire loop and then came out.
            if (isEmpty == false) {
                break;
            }
        }

        if (isEmpty == true) {

            // sudoku solved.
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;
                if (solve(grid)) {

                    // checking each time whether that element that is placed is
                    // correct or not.
                    return true;
                }

                else {

                    // if the placed number is false then backtrack.
                    grid[row][col] = 0;
                }
            }
        }

        // sudoku cannot be solved.
        return false;

    }

    public static boolean isSafe(int[][] grid, int row, int col, int num) {

        // checking for row
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }

        // checking for col
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }

        // checking for that particular box
        int sqrt = (int) (Math.sqrt(grid.length));
        int row_start = row - row % sqrt;
        int col_start = col - col % sqrt;

        for (int i = row_start; i < row_start + sqrt; i++) {
            for (int j = col_start; j < col_start + sqrt; j++) {
                if (grid[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + "  ");
            }

            System.out.println();
        }
    }

}