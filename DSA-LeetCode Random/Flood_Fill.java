//https://leetcode.com/problems/flood-fill/description/?envType=study-plan&id=level-1

import java.util.Arrays;

public class Flood_Fill {
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int color = 2;
        floodFill(image, sr, sc, color);
        System.out.println(Arrays.deepToString(image));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        int source = image[sr][sc];
        dfs(image, sr, sc, color, source);
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int color, int source) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != source) {
            return;
        }

        image[sr][sc] = color;

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        for (int k = 0; k < 4; k++) {
            int nx = sr + dx[k];
            int ny = sc + dy[k];
            dfs(image, nx, ny, color, source);
        }
    }
}
