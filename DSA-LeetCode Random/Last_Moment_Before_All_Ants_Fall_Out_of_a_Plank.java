// https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/?envType=daily-question&envId=2023-11-04

public class Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank {
    public static void main(String[] args) {
        int n = 4;
        int[] left = { 4, 3 };
        int[] right = { 0, 1 };

        System.out.println(getLastMoment(n, left, right));
    }

    public static int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;

        for (int i : left) {
            lastMoment = Math.max(lastMoment, i);
        }

        for (int i : right) {
            lastMoment = Math.max(lastMoment, n - i);
        }

        return lastMoment;
    }
}
