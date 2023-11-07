// https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/?envType=daily-question&envId=2023-11-07

import java.util.Arrays;

public class Eliminate_Maximum_Number_of_Monsters {
    public static void main(String[] args) {
        int[] dist = { 1, 3, 4 };
        int[] speed = { 1, 1, 1 };
        System.out.println(eliminateMaximum(dist, speed));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        int[] time = new int[dist.length];

        // time = dist / speed
        // make sure to convert to double first, otherwise it will be rounded down.
        for (int i = 0; i < dist.length; i++) {
            time[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }

        Arrays.sort(time);

        // since gun is loaded at time 0, we can eliminate 1 monster at time 1.
        int count = 1;
        int timePass = 1;

        for (int i = 1; i < time.length; i++) {
            if (time[i] - timePass <= 0) {
                return count;
            }

            timePass++;
            count++;
        }

        return count;
    }
}
