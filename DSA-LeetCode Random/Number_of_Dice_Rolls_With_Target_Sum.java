// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/?envType=daily-question&envId=2023-12-26

import java.util.Arrays;

public class Number_of_Dice_Rolls_With_Target_Sum {
    private static final long M = 1000000007;
    private static int[][] t = new int[32][1002];

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1, 6, 3));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        for (int i = 0; i < 32; i++) {
            Arrays.fill(t[i], -1);
        }

        return solve(n, k, target);
    }

    public static int solve(int n, int k, int target) {
        if (target < 0 || n == 0)
            return target == 0 ? 1 : 0;

        if (t[n][target] != -1)
            return t[n][target];

        int sum = 0;

        for (int i = 1; i <= k; i++) {
            sum = (sum + solve(n - 1, k, target - i)) % (int) M;
        }

        return t[n][target] = sum;
    }
}
