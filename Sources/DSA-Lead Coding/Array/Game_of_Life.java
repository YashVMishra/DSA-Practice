//https://leetcode.com/problems/game-of-life/description/

import java.util.Arrays;

public class Game_of_Life {
    public static void main(String[] args) {
        int[][] arr = { { 1, 1 }, { 1, 0 } };
        gameOfLife(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public static void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[][] temp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (temp[i][j] == 1) {
                    int count = live_cell(temp, i, j);
                    if (count < 2) {
                        board[i][j] = 0;
                    }

                    else if (count == 2 || count == 3) {
                        board[i][j] = 1;
                    }

                    else {
                        board[i][j] = 0;
                    }
                }

                else {
                    int count = live_cell(temp, i, j);
                    if (count == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    public static int live_cell(int[][] temp, int row, int col) {
        int count = 0;
        if (row - 1 >= 0 && row - 1 < temp.length && col - 1 >= 0 && col - 1 < temp[0].length
                && temp[row - 1][col - 1] == 1) {
            count++;
        }

        if (row - 1 >= 0 && row - 1 < temp.length && col >= 0 && col < temp[0].length
                && temp[row - 1][col] == 1) {
            count++;
        }

        if (row - 1 >= 0 && row - 1 < temp.length && col + 1 >= 0 && col + 1 < temp[0].length
                && temp[row - 1][col + 1] == 1) {
            count++;
        }

        if (row >= 0 && row < temp.length && col + 1 >= 0 && col + 1 < temp[0].length
                && temp[row][col + 1] == 1) {
            count++;
        }

        if (row + 1 >= 0 && row + 1 < temp.length && col + 1 >= 0 && col + 1 < temp[0].length
                && temp[row + 1][col + 1] == 1) {
            count++;
        }

        if (row + 1 >= 0 && row + 1 < temp.length && col >= 0 && col < temp[0].length
                && temp[row + 1][col] == 1) {
            count++;
        }

        if (row + 1 >= 0 && row + 1 < temp.length && col - 1 >= 0 && col - 1 < temp[0].length
                && temp[row + 1][col - 1] == 1) {
            count++;
        }

        if (row >= 0 && row < temp.length && col - 1 >= 0 && col - 1 < temp[0].length
                && temp[row][col - 1] == 1) {
            count++;
        }

        return count;
    }

}
