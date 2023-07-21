//https://leetcode.com/problems/put-marbles-in-bags/description/

import java.util.ArrayList;
import java.util.Collections;

public class Put_Marbles_in_Bags {
    public static void main(String[] args) {
        int[] weights = { 1, 3, 5, 1 };
        int k = 2;
        System.out.println(putMarbles(weights, k));
    }

    public static long putMarbles(int[] weights, int k) {
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < weights.length - 1; i++) {
            long sum = (long) (weights[i]) + (long) (weights[i + 1]);
            list.add(sum);
        }

        long minSum = 0;
        long maxSum = 0;
        Collections.sort(list);

        for (int i = 0; i < k - 1; i++) {
            minSum += list.get(i);
            maxSum += list.get(list.size() - 1 - i);
        }

        return maxSum - minSum;
    }
}
