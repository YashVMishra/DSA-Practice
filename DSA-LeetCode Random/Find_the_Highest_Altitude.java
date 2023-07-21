//https://leetcode.com/problems/find-the-highest-altitude/submissions/974749917/

public class Find_the_Highest_Altitude {
    public static void main(String[] args) {
        int[] gain = { -4, -3, -2, -1, 4, 3, 2 };
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int totalAltitude = 0;

        for (int i : gain) {
            totalAltitude += i;
            maxAltitude = Math.max(maxAltitude, totalAltitude);
        }

        return maxAltitude;
    }
}