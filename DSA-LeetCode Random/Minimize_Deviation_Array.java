//https://leetcode.com/problems/minimize-deviation-in-array/description/

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Minimize_Deviation_Array {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 5, 20, 3 };
        System.out.println(minimumDeviation(nums));
        System.out.println(minimumDeviation_2(nums));
    }

    public static int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // min should not be the minimum value of the original array
        // instead it should be of the modified array.
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i % 2 != 0) {
                i *= 2;
            }

            min = Math.min(min, i);
            pq.add(i);
        }

        int diff = Integer.MAX_VALUE;
        while (true) {

            // loop should run until the max is even.
            if (pq.peek() % 2 != 0) {
                int max = pq.remove();
                diff = Math.min(diff, max - min);
                break;
            }

            int max = pq.remove();
            diff = Math.min(diff, max - min);

            // important as there might be a chance that when we do max/2
            // it becomes less than min so we have to update the min.
            min = Math.min(max / 2, min);
            pq.add(max / 2);
        }

        return diff;
    }

    // better TC.
    public static int minimumDeviation_2(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();

        for (int i : nums) {
            if (i % 2 != 0) {
                i *= 2;
            }

            ts.add(i);
        }

        int diff = Integer.MAX_VALUE;
        while (true) {

            // finding max and min value
            int max = ts.last();
            int min = ts.first();

            diff = Math.min(diff, max - min);

            if (max % 2 == 0) {
                ts.remove(max);
                ts.add(max / 2);
            }

            // break loop when max is odd.
            else {
                break;
            }
        }

        return diff;
    }
}
