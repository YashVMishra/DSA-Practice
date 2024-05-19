// https://leetcode.com/problems/find-the-maximum-sum-of-node-values/description/?envType=daily-question&envId=2024-05-19

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find_the_Maximum_Sum_of_Node_Values {
    public static void main(String[] args) {
        int[] nums = { 3, 7, 1, 4, 5, 9, 2 };
        int k = 6;
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 3, 7 } };

        long result = maximumValueSum(nums, k, edges);
        System.out.println(result);
    }

    // Approach-1 (Greedily picking nodes to xor)
    // T.C : O(n)
    // S.C : O(1)
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        int minNukasan = Integer.MAX_VALUE;

        for (int num : nums) {
            if ((num ^ k) > num) {
                count++;
                sum += (num ^ k);
            } else {
                sum += num;
            }

            minNukasan = Math.min(minNukasan, Math.abs(num - (num ^ k)));
        }

        if (count % 2 == 0)
            return sum;

        return sum - minNukasan;
    }

    // ---------------------------------------------------------------------------------

    // Approach-2(Greedy + Sorting)
    // T.C : O(nlogn)
    // S.C : O(n)
    public static long maximumValueSum_2(int[] nums, int k, int[][] edges) {
        List<Integer> fayda = new ArrayList<>();
        long normalSum = 0;

        for (int num : nums) {
            fayda.add((num ^ k) - num);
            normalSum += (long) num;
        }

        Collections.sort(fayda, Collections.reverseOrder());

        for (int i = 0; i < fayda.size() - 1; i += 2) {
            long pairSum = fayda.get(i) + fayda.get(i + 1);

            if (pairSum > 0) {
                normalSum += pairSum;
            }
        }
        return normalSum;
    }
}
