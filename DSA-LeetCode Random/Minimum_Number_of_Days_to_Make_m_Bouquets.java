// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/?envType=daily-question&envId=2024-06-19

import java.util.Arrays;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {
    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;

        System.out.println(minDays(bloomDay, m, k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        // If it's impossible to get m bouquets
        if (bloomDay.length < m * k) {
            return -1;
        }

        int startDay = 1;
        int endDay = Arrays.stream(bloomDay).max().getAsInt();
        int minDays = -1;

        while (startDay <= endDay) {
            int mid = startDay + (endDay - startDay) / 2;

            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                endDay = mid - 1;
            } else {
                startDay = mid + 1;
            }
        }

        return minDays;
    }

    public static int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int consecutiveCount = 0;

        // Find count of consecutive flowers you can pick at mid day.
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                consecutiveCount++;
            } else {
                consecutiveCount = 0;
            }
            if (consecutiveCount == k) {
                numOfBouquets++;
                consecutiveCount = 0;
            }
        }
        return numOfBouquets;
    }
}
