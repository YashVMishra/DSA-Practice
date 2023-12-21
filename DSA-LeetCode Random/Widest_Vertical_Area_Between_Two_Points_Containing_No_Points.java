// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/description/?envType=daily-question&envId=2023-12-21

import java.util.Arrays;

public class Widest_Vertical_Area_Between_Two_Points_Containing_No_Points {
    public static void main(String[] args) {
        int[][] points = { { 8, 7 }, { 9, 9 }, { 7, 4 }, { 9, 7 } };
        System.out.println(maxWidthOfVerticalArea(points));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int max = 0;

        for (int i = 0; i < points.length - 1; ++i) {
            max = Math.max(max, points[i + 1][0] - points[i][0]);
        }

        return max;
    }
}
