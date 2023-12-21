public class Image_Smoother {
    public static void main(String[] args) {
        int[][] M = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] result = imageSmoother(M);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        int[][] directions = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
                { 1, 1 } };

        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M[0].length; ++j) {

                int sum = M[i][j];
                int count = 1;

                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];

                    if (x >= 0 && x < M.length && y >= 0 && y < M[0].length) {
                        sum += M[x][y];
                        ++count;
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }
}