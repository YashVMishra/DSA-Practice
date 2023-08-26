// https://leetcode.com/problems/maximum-length-of-pair-chain/description/

import java.util.Arrays;
import java.util.Comparator;

public class Maximum_Length_of_Pair_Chain {
    public static void main(String[] args) {
        int[][] pairs = { { 1, 2 }, { 7, 8 }, { 4, 5 } };
        System.out.println(findLongestChain(pairs));
    }

    // similar to greedy approach of activity selection problem.
    public static int findLongestChain(int[][] pairs) {
        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return Integer.compare(a1[1], a2[1]);
            }
        };

        Arrays.sort(pairs, comp);
        int prev = pairs[0][1];
        int count = 1;

        for (int[] arr : pairs) {
            if (arr[0] > prev) {
                count++;
                prev = arr[1];
            }
        }

        return count;
    }
}
