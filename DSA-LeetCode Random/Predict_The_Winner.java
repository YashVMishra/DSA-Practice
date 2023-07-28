// https://leetcode.com/problems/predict-the-winner/description/

public class Predict_The_Winner {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 233, 7 };
        System.out.println(PredictTheWinner(nums));
    }

    public static boolean PredictTheWinner(int[] nums) {
        boolean choose = true;
        int n = nums.length;
        int score = solve(nums, 0, n - 1, choose);

        return score >= 0;
    }

    public static int solve(int[] nums, int i, int j, boolean choose) {
        if (i > j) {
            return 0;
        }

        int ans = 0;

        if (choose) {
            ans = Math.max(nums[i] + solve(nums, i + 1, j, false), nums[j] + solve(nums, i, j - 1, false));
        } else {
            ans = Math.min(-nums[i] + solve(nums, i + 1, j, true), -nums[j] + solve(nums, i, j - 1, true));
        }
        return ans;
    }
}
