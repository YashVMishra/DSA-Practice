// https://leetcode.com/problems/student-attendance-record-ii/description/?envType=daily-question&envId=2024-05-26

import java.util.Arrays;

public class Student_Attendance_Record_2 {
    static int M = 1000000007;
    static int[][][] t = new int[100001][2][3];

    public static void main(String[] args) {
        System.out.println(checkRecord(2));
    }

    public static int checkRecord(int n) {
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }

        return solve(n, 0, 0);
    }

    private static int solve(int n, int absent, int consecutiveLate) {
        if (absent >= 2 || consecutiveLate >= 3) {
            return 0;
        }

        if (n == 0)
            return 1;

        if (t[n][absent][consecutiveLate] != -1) {
            return t[n][absent][consecutiveLate];
        }

        int A = solve(n - 1, absent + 1, 0) % M;
        int L = solve(n - 1, absent, consecutiveLate + 1) % M;
        int P = solve(n - 1, absent, 0) % M;

        return t[n][absent][consecutiveLate] = ((A + L) % M + P) % M;
    }
}