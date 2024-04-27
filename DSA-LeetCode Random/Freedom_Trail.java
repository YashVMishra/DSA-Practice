// https://leetcode.com/problems/freedom-trail/description/?envType=daily-question&envId=2024-04-27

import java.util.Arrays;

public class Freedom_Trail {
    private static int[][] t = new int[101][101];

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        System.out.println(findRotateSteps(ring, key));
    }

    public static int findRotateSteps(String ring, String key) {
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, ring, key);
    }

    private static int solve(int ringIndex, int keyIndex, String ring, String key) {
        if (keyIndex == key.length()) {
            return 0;
        }

        if (t[ringIndex][keyIndex] != -1) {
            return t[ringIndex][keyIndex];
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(keyIndex)) {
                int totalSteps = countSteps(ringIndex, i, ring.length()) + 1 +
                        solve(i, keyIndex + 1, ring, key);
                result = Math.min(result, totalSteps);
            }
        }

        return t[ringIndex][keyIndex] = result;
    }

    private static int countSteps(int ringIndex, int i, int n) {
        int dist = Math.abs(i - ringIndex);
        int wrapAround = n - dist;

        return Math.min(dist, wrapAround);
    }
}
