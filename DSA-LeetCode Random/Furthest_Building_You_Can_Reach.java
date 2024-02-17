// https://leetcode.com/problems/furthest-building-you-can-reach/description/?envType=daily-question&envId=2024-02-17

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Furthest_Building_You_Can_Reach {
    static private int n;
    static private int[][] t;

    public static void main(String[] args) {
        int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
        int bricks = 5;
        int ladders = 1;

        System.out.println(furthestBuilding(heights, bricks, ladders));
        System.out.println(furthestBuilding_2(heights, bricks, ladders));
    }

    // using lazy greedy method.
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1])
                continue;
            bricks -= heights[i + 1] - heights[i];
            pq.add(heights[i + 1] - heights[i]);

            if (bricks < 0) {
                bricks += pq.poll();
                if (ladders > 0)
                    ladders--;
                else
                    return i;
            }
        }

        return heights.length - 1;
    }

    // --------------------------------------------------------------------------------

    // using dynamic programming.
    // not accepted on leetcode.
    public static int furthestBuilding_2(int[] heights, int bricks, int ladders) {
        n = heights.length;

        t = new int[bricks + 1][ladders + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(0, heights, bricks, ladders);
    }

    private static int solve(int idx, int[] heights, int bricks, int ladders) {
        if (idx == n - 1) // we reached the last building and no need to move further
            return 0;

        if (t[bricks][ladders] != -1)
            return t[bricks][ladders];

        if (heights[idx] >= heights[idx + 1]) { // No need to use anything. Just move ahead
            t[bricks][ladders] = 1 + solve(idx + 1, heights, bricks, ladders);
        } else {

            int byBrick = 0;
            int byLadder = 0;
            if (bricks >= heights[idx + 1] - heights[idx])
                byBrick = 1 + solve(idx + 1, heights, bricks - (heights[idx + 1] - heights[idx]), ladders);

            if (ladders > 0)
                byLadder = 1 + solve(idx + 1, heights, bricks, ladders - 1);

            t[bricks][ladders] = Math.max(byBrick, byLadder);
        }

        return t[bricks][ladders];
    }
}
