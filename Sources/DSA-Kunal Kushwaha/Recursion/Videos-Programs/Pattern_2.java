/*
 Print the pattern
 * 
 * * 
 * * * 
 * * * * 
 */

public class Pattern_2 {
    public static void main(String[] args) {
        pattern(4, 0);
    }

    static void pattern(int row, int column) {
        if (row == 0) {
            return;
        }

        if (column < row) {
            pattern(row, column + 1);
            System.out.print("*" + " ");
        }

        else {
            pattern(row - 1, 0);
            System.out.println();
        }
    }
}
