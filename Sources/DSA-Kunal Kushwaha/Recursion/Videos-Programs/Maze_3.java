public class Maze_3 {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = true;
            }
        }

        arr[1][1] = false;

        path("", 0, 0, arr);
    }

    public static void path(String ans, int row, int col, boolean[][] arr) {
        // int row = arr.length;
        // int col = arr[0].length;
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.print(ans + " ");
            return;
        }

        if (!arr[row][col]) {
            return;
        }

        if (row < arr.length - 1 && col < arr[0].length - 1) {
            if (!arr[row + 1][col + 1]) {
                ;
            }
            path(ans + "D", row + 1, col + 1, arr);
        }

        if (row < arr.length - 1) {
            path(ans + "H", row + 1, col, arr);
        }

        if (col < arr[0].length - 1) {
            path(ans + "V", row, col + 1, arr);
        }

    }
}
