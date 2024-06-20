// https://leetcode.com/problems/magnetic-force-between-two-balls/description/

import java.util.Arrays;

public class Magnetic_Force_Between_Two_Balls {
    public static void main(String[] args) {
        int[] position = { 1, 2, 3, 4, 7 };
        int m = 3;

        System.out.println(maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int minForce = 1;
        int maxForce = position[n - 1] - position[0]; // This value is the maximum possible distance

        int result = 0;
        while (minForce <= maxForce) {
            int midForce = minForce + (maxForce - minForce) / 2;

            if (possibleToPlace(midForce, position, m)) {
                result = midForce;
                minForce = midForce + 1;
            } else {
                maxForce = midForce - 1;
            }
        }

        return result;
    }

    public static boolean possibleToPlace(int force, int[] position, int m) {
        int prev = position[0];
        int countBalls = 1;

        for (int i = 1; i < position.length; i++) {
            int curr = position[i];

            if (curr - prev >= force) {
                countBalls++;
                prev = curr;
            }

            if (countBalls == m) {
                break;
            }
        }

        return countBalls == m;
    }
}
