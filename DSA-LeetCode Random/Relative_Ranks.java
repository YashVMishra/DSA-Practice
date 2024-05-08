// https://leetcode.com/problems/relative-ranks/description/?envType=daily-question&envId=2024-05-08

import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int index;
    int value;

    Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class Relative_Ranks {
    public static void main(String[] args) {
        int[] score = { 5, 2, 13, 3, 8 };

        // System.out.println(Arrays.toString(findRelativeRanks(score)));
        System.out.println(Arrays.toString(findRelativeRanks_2(score)));
    }

    // finding maxIndex in each iteration.
    public static String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            int maxIndex = -1;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < score.length; j++) {
                if (score[j] > max) {
                    max = score[j];
                    maxIndex = j;
                }
            }

            if (i == 0) {
                result[maxIndex] = "Gold Medal";
            } else if (i == 1) {
                result[maxIndex] = "Silver Medal";
            } else if (i == 2) {
                result[maxIndex] = "Bronze Medal";
            } else {
                result[maxIndex] = String.valueOf(i + 1);
            }

            score[maxIndex] = Integer.MIN_VALUE;
        }

        return result;
    }

    // --------------------------------------------------------------------------------

    public static String[] findRelativeRanks_2(int[] score) {
        String[] result = new String[score.length];

        // make max-heap to store the values and indexes.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.value - a.value);

        for (int i = 0; i < score.length; i++) {
            pq.add(new Pair(i, score[i]));
        }

        for (int i = 0; i < score.length; i++) {
            Pair current = pq.poll();

            if (i == 0) {
                result[current.index] = "Gold Medal";
            } else if (i == 1) {
                result[current.index] = "Silver Medal";
            } else if (i == 2) {
                result[current.index] = "Bronze Medal";
            } else {
                result[current.index] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}