//https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/

import java.util.Arrays;

public class Rat_In_a_Maze {
    public static void main(String[] args) {
        int[][] arr = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }, };

        int[][] ans = new int[arr.length][arr[0].length];

        maze(arr, 0, 0, "", ans);
        ans[0][0] = 1;
        System.out.println(Arrays.deepToString(ans));
    }

    public static void maze(int[][] arr, int i, int j, String str, int[][] ans) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            System.out.println(str);
            return;
        }

        if (i + 1 >= 0 && j >= 0 && i + 1 < arr.length && j < arr[0].length && arr[i + 1][j] == 1) {
            arr[i + 1][j] = 999;
            ans[i + 1][j] = 1;
            maze(arr, i + 1, j, str + "D", ans);

            // while backtracking making the element as it was.
            arr[i + 1][j] = 1;

        }

        if (i >= 0 && j + 1 >= 0 && i < arr.length && j + 1 < arr[0].length && arr[i][j + 1] == 1) {
            arr[i][j + 1] = 999;
            ans[i][j + 1] = 1;
            maze(arr, i, j + 1, str + "F", ans);
            arr[i][j + 1] = 1;
        }
    }
}