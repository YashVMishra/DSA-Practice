// https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/?envType=daily-question&envId=2023-12-13

import java.util.HashSet;

public class Special_Positions_in_a_Binary_Matrix {
    public static void main(String[] args) {
        int[][] mat = { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
        int result = numSpecial(mat);
        System.out.println(result);
    }

    public static int numSpecial(int[][] mat) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        // adding those row which have only one 1.
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }

            if (sum == 1) {
                rows.add(i);
            }
        }

        // adding those col which have only one 1.
        for (int j = 0; j < mat[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < mat.length; i++) {
                sum += mat[i][j];
            }

            if (sum == 1) {
                cols.add(j);
            }
        }

        // the intersection of the cells made by rows and cols
        // of the sets can be the special positions.
        // so if that intersection cell have 1 then we will count it.
        int count = 0;
        for (int i : rows) {
            for (int j : cols) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    // -----------------------------------------------------------------------------------

    public static int numSpecial_2(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];

        // counting the number of 1's in each row and col.
        // increase the count of the row and col if 1 is found.
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; i++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        // if the mat[i][j] == 1 and the count of that row and col is 1
        // then we increase the count.
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            if (rows[i] == 1) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (cols[j] == 1 && mat[i][j] == 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
