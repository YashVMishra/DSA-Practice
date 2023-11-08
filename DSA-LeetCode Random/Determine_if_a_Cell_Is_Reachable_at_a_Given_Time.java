// https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/description/?envType=daily-question&envId=2023-11-08

public class Determine_if_a_Cell_Is_Reachable_at_a_Given_Time {
    private static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, 1 }, { 1, -1 }, { 1, 1 },
            { -1, -1 } };

    public static void main(String[] args) {
        System.out.println(isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println(isReachableAtTime_2(2, 4, 7, 7, 6));
    }

    // using DFS but shows TLE
    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        return solve(sx, sy, fx, fy, t);
    }

    private static boolean solve(int sx, int sy, int fx, int fy, int t) {
        if (sx < 0 || sy < 0) {
            return false;
        }

        if (t == 0) {
            return sx == fx && sy == fy;
        }

        for (int[] dir : directions) {
            int x = sx + dir[0];
            int y = sy + dir[1];

            if (solve(x, y, fx, fy, t - 1)) {
                return true;
            }
        }

        return false;
    }

    // ---------------------------------------------------------------------------------

    public static boolean isReachableAtTime_2(int sx, int sy, int fx, int fy, int t) {
        int vertDist = Math.abs(sy - fy);
        int horDist = Math.abs(sx - fx);

        if (vertDist == 0 && horDist == 0 && t == 1) {
            return false;
        }

        return t >= Math.max(vertDist, horDist);
    }
}
