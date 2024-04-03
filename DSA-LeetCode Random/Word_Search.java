// https://leetcode.com/problems/word-search/description/?envType=daily-question&envId=2024-04-03

public class Word_Search {
    static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (findBacktracking(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean findBacktracking(int i, int j, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index) | board[i][j] == '$') {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for (int[] dir : dirs) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if (findBacktracking(i_, j_, index + 1, board, word)) {
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}
