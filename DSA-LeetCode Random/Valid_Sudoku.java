//https://leetcode.com/problems/valid-sudoku/description/

public class Valid_Sudoku {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (isValid(board, i, j, board[i][j]) == false) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean isValid(char[][] grid, int row, int col, char num) {

        // checking for row
        for (int i = 0; i < grid.length; i++) {

            // we have done i!=row as the num will be present
            // on the row and col which we have passed as parameter.
            if (grid[i][col] == num && i != row) {
                return false;
            }
        }

        // checking for col
        for (int i = 0; i < grid.length; i++) {

            // we have done i!=col as the num will be present
            // on the row and col which we have passed as parameter.
            if (grid[row][i] == num && i != col) {
                return false;
            }
        }

        // checking for that particular box
        int sqrt = (int) (Math.sqrt(grid.length));
        int row_start = row - row % sqrt;
        int col_start = col - col % sqrt;

        for (int i = row_start; i < row_start + sqrt; i++) {
            for (int j = col_start; j < col_start + sqrt; j++) {

                // we have done i!=row and j!=col as the num will be present
                // on the row and col which we have passed as parameter.
                if (grid[i][j] == num && (i != row && j != col)) {
                    return false;
                }
            }
        }

        return true;
    }
}
