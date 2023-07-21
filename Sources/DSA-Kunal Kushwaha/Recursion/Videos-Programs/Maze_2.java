public class Maze_2 {
    public static void main(String[] args) {
        path("", 3, 3);
    }

    public static void path(String ans, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.print(ans + " ");
            return;
        }

        if (row > 1 && col > 1) {
            path(ans + "D", row - 1, col - 1);
        }

        if (row > 1) {
            path(ans + "H", row - 1, col);
        }

        if (col > 1) {
            path(ans + "V", row, col - 1);
        }

    }
}
