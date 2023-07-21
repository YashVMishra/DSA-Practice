//https://leetcode.com/problems/maximum-length-of-pair-chain/description/

import java.util.Comparator;
import java.util.Arrays;

public class Max_Pair_Chain {
    public static void main(String[] args) {
        int[][] pairs = { { 1, 2 }, { 7, 8 }, { 4, 5 } };
        System.out.println(findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if (a1[1] < a2[1]) {
                    return -1;
                }

                else if (a1[1] > a2[1]) {
                    return 1;
                }

                return 0;
            }
        });

        int max_length = 1;
        int prev = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (prev < pairs[i][0]) {
                max_length++;
                prev = pairs[i][1];
            }
        }

        return max_length;
    }
}