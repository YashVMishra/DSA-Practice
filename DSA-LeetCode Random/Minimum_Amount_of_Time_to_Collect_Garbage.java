// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/?envType=daily-question&envId=2023-11-20

public class Minimum_Amount_of_Time_to_Collect_Garbage {
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[] { "G", "P", "GP", "GG" },
                new int[] { 2, 4, 3 }));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int garbagetTime = 0;
        int pIndex = -1, gIndex = -1, mIndex = -1;
        int travelTime = 0;

        // calculate the index of last occurence of P, G, M
        // garbagetTime is the sum of length of all garbage strings
        // as every individual garbage needs 1 min so length of string is
        // the time taken to collect that garbage
        for (int i = 0; i < garbage.length; i++) {
            garbagetTime += garbage[i].length();

            if (garbage[i].contains("P")) {
                pIndex = i;
            }

            if (garbage[i].contains("G")) {
                gIndex = i;
            }

            if (garbage[i].contains("M")) {
                mIndex = i;
            }
        }

        travelTime = timeCalculate(travel, pIndex) + timeCalculate(travel, gIndex)
                + timeCalculate(travel, mIndex);

        return garbagetTime + travelTime;
    }

    private static int timeCalculate(int[] travel, int end) {
        int totalTime = 0;

        for (int i = 0; i < end; i++) {
            totalTime += travel[i];
        }

        return totalTime;
    }
}
