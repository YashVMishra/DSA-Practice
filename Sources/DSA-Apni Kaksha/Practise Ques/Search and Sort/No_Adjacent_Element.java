//https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class No_Adjacent_Element {
    public static void main(String[] args) {
        int[] arr = { 5, 5, 10, 100, 10, 5 };
        int[] dp = new int[arr.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(maxSum(arr, arr.length - 1, dp));
        System.out.println(maxSum_2(arr));
        System.out.println(maxSum_3(arr));
    }

    // DP with memoization.
    public static int maxSum(int[] arr, int ind, int[] dp) {
        if (ind < 0) {
            return 0;
        }

        if (ind == 0) {
            return arr[0];
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int pick = arr[ind] + maxSum(arr, ind - 2, dp);
        int not_pick = 0 + maxSum(arr, ind - 1, dp);

        dp[ind] = Math.max(pick, not_pick);

        return dp[ind];
    }

    // DP with tabulation.
    public static int maxSum_2(int[] arr) {
        int[] dp = new int[arr.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }

        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int take = arr[i];

            if (i > 1) {
                take += dp[i - 2];
            }

            int notTake = 0 + dp[i - 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[dp.length - 1];
    }

    // DP with space optimization.
    public static int maxSum_3(int[] arr) {

        int prev = arr[0];
        int prev_2 = 0;

        for (int i = 1; i < arr.length; i++) {

            int take = arr[i] + prev_2;
            int notTake = 0 + prev;

            int cur_i = Math.max(take, notTake);

            prev_2 = prev;
            prev = cur_i;
        }

        return prev;
    }

}
