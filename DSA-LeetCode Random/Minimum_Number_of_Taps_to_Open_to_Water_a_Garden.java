// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/description/

public class Minimum_Number_of_Taps_to_Open_to_Water_a_Garden {
    public static void main(String[] args) {
        int n = 5;
        int[] ranges = { 3, 4, 1, 1, 0, 0 };
        System.out.println(minTaps(n, ranges));
    }

    public static int minTaps(int n, int[] ranges) {
        int[] startEnd = new int[n + 1];

        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            startEnd[start] = Math.max(startEnd[start], end);
        }

        int taps = 0;
        int currEnd = 0;
        int maxEnd = 0;

        for (int i = 0; i < n + 1; i++) {
            if (i > maxEnd) {
                return -1;
            }

            if (i > currEnd) {
                taps++;
                currEnd = maxEnd;
            }

            maxEnd = Math.max(maxEnd, startEnd[i]);
        }

        return taps;
    }
}
