// https://leetcode.com/problems/minimum-time-visiting-all-points/?envType=daily-question&envId=2023-12-03

public class Minimum_Time_Visiting_All_Points {
    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 3, 4 }, { -1, 0 } };
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int steps = 0;

        for (int i = 0; i < n - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];

            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

            int diagonal = Math.min(dx, dy);
            int remain = Math.abs(dx - dy);

            steps += diagonal + remain;
        }

        return steps;
    }
}
