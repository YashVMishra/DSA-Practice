//https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.ArrayList;

public class N_Queen {
    public static void main(String[] args) {
        System.out.println(nQueen(4));
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        int[][] arr = new int[n][n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        return (queens(arr, 0, list));
    }

    public static ArrayList<ArrayList<Integer>> queens(int[][] arr, int row, ArrayList<ArrayList<Integer>> list) {
        if (row == arr.length) {
            list.add(indexes(arr));
            return list;
        }

        for (int col = 0; col < arr[0].length; col++) {
            if (is_safe(arr, row, col)) {
                arr[row][col] = 1;
                queens(arr, row + 1, list);
                arr[row][col] = 0;
            }
        }

        return list;
    }

    public static boolean is_safe(int[][] arr, int row, int col) {

        // checking for the vertical up
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 1) {
                return false;
            }
        }

        // checking for left diagonal
        // max_left is the number of element that have to be checked on the left
        // diagonal
        int max_left = Math.min(row, col); // important
        for (int i = 1; i <= max_left; i++) {
            if (arr[row - i][col - i] == 1) {
                return false;
            }
        }

        // checking for right diagonal
        // max_rigth is the number of elements that have to be checked on the rigth
        // diagonal
        int max_right = Math.min(row, arr[0].length - 1 - col); // important
        for (int i = 1; i <= max_right; i++) {
            if (arr[row - i][col + i] == 1) {
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Integer> indexes(int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    list.add(j + 1);
                }
            }
        }

        return list;
    }
}
