class Maze_4 {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = true;
            }
        }

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

        arr[row][col] = false;

        if (row > 0) {
            path(ans + "U", row - 1, col, arr);
        }

        if (row < arr.length - 1) {
            path(ans + "R", row + 1, col, arr);
        }

        if (col < arr[0].length - 1) {
            path(ans + "D", row, col + 1, arr);
        }

        if (col > 0) {
            path(ans + "L", row, col - 1, arr);
        }

        arr[row][col] = true;
    }
}