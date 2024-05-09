// https://leetcode.com/problems/maximize-happiness-of-selected-children/description/?envType=daily-question&envId=2024-05-09

import java.util.Arrays;

public class Maximize_Happiness_of_Selected_Children {
    public static void main(String[] args) {
        int[] happiness = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 4;

        System.out.println(maximumHappinessSum(happiness, k));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        long totalhappiness = 0;
        Arrays.sort(happiness);

        for (int i = 0; i < k; i++) {
            long localHappiness = happiness[happiness.length - 1 - i] - i;
            totalhappiness += Math.max(0, localHappiness);
        }

        return totalhappiness;
    }
}
