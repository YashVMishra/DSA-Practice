public class Find_All_Groups_of_Farmland {
    static int m;
    static int n;
    static int[][] result;
    static int resultIndex;
    static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        int[][] land = { { 1, 0, 0 }, { 0, 1, 1 }, { 0, 1, 1 } };
        int[][] result = findFarmland(land);

        for (int[] res : result) {
            for (int val : res) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }

    private static int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;
        result = new int[m * n][4];
        resultIndex = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] r1 = { i };
                    int[] c1 = { j };
                    int[] r2 = { -1 };
                    int[] c2 = { -1 };

                    dfs(land, i, j, r2, c2);
                    result[resultIndex++] = new int[] { r1[0], c1[0], r2[0], c2[0] };
                }
            }
        }

        // Trimming the result array to remove any excess null values
        int[][] trimmedResult = new int[resultIndex][4];
        System.arraycopy(result, 0, trimmedResult, 0, resultIndex);
        return trimmedResult;
    }

    private static void dfs(int[][] land, int i, int j, int[] r2, int[] c2) {
        land[i][j] = 0;

        r2[0] = Math.max(r2[0], i);
        c2[0] = Math.max(c2[0], j);

        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && land[i_][j_] == 1) {
                dfs(land, i_, j_, r2, c2);
            }
        }
    }
}
