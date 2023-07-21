//https://leetcode.com/problems/check-if-it-is-a-straight-line/description/

public class Check_If_It_Is_a_Straight_Line {
    public static void main(String[] args) {
        int[][] coordinates = { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } };
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {

        int deltaY = getYDiff(coordinates[1], coordinates[0]);
        int deltaX = getXDiff(coordinates[1], coordinates[0]);

        for (int i = 2; i < coordinates.length; i++) {
            if (deltaX * getYDiff(coordinates[i], coordinates[0]) != deltaY
                    * getXDiff(coordinates[i], coordinates[0])) {
                return false;
            }
        }

        return true;
    }

    public static int getXDiff(int[] a, int[] b) {
        return a[0] - b[0];
    }

    public static int getYDiff(int[] a, int[] b) {
        return a[1] - b[1];
    }
}
