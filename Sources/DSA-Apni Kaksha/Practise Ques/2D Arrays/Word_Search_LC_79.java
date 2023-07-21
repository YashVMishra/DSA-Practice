public class Word_Search_LC_79 {
    public static void main(String[] args) {
        char[][] arr = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(arr, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(i, j, board, word)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean dfs(int i, int j, char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (i < 0 || j < 0 || j >= board[0].length || i >= board.length || board[i][j] != word.charAt(0)) {
            return false;
        }

        char ch = board[i][j];
        board[i][j] = ' ';

        if (dfs(i + 1, j, board, word.substring(1)) || dfs(i - 1, j, board, word.substring(1)) ||
                dfs(i, j + 1, board, word.substring(1)) || dfs(i, j - 1, board, word.substring(1))) {
            return true;
        }

        board[i][j] = ch;
        return false;

    }
}
