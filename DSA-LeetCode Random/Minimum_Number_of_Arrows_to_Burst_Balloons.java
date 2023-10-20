// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Number_of_Arrows_to_Burst_Balloons {
    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        int overlap = -1;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int[] prev = points[0];
        for (int[] point : points) {
            if (point[0] > prev[1]) {
                prev = point;
            } else {
                overlap++;
            }
        }

        return points.length - overlap;
    }
}
