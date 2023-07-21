//https://practice.geeksforgeeks.org/problems/longest-possible-route-in-a-matrix-with-hurdles/1

public class Longest_Route {
    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        System.out.println(longestPath(arr, 3, 10, 0, 0, 1, 7));
    }

    public static int longestPath(int[][] mat, int n, int m, int xs, int ys, int xd, int yd) {
        // code here
        if (mat[xd][yd] == 0 || mat[xs][ys] == 0) {
            return -1;
        }

        // here we have taken a single element array as we have to modify this very
        // element as its our requird longest route
        int[] ans = { -1 };

        longest_route(mat, n, m, xs, ys, xd, yd, 0, ans);

        return ans[0];
    }

    public static void longest_route(int[][] mat, int row, int col, int xs, int ys, int xd, int yd, int count,
            int[] ans) {
        if (xs == xd && yd == ys) {
            if (count > ans[0]) {
                ans[0] = count;
                return;
            }
        }

        // we have created this pair as it will make
        // the four directions.
        int[][] pair = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // changing the value of the current x and y
        // as we dont have to include this again.
        mat[xs][ys] = 2;

        for (int[] i : pair) {
            int newX = xs + i[0];
            int newY = ys + i[1];

            if (newX >= 0 && newX < row && newY >= 0 && newY < col && mat[newX][newY] == 1) {
                longest_route(mat, row, col, newX, newY, xd, yd, count + 1, ans);
            }
        }

        // backtacking
        mat[xs][ys] = 1;
    }

}