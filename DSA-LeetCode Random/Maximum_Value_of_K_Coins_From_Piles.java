//https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maximum_Value_of_K_Coins_From_Piles {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>(Arrays.asList(1, 100, 3)));
        list.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

        int k = 2;
        System.out.println(maxValueOfCoins(list, k));
    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // return func_recursion(0, k, piles);
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        return func_dp(0, k, piles, dp);
    }

    public static int func_recursion(int i, int k, List<List<Integer>> piles) {
        if (i == piles.size() || k == 0) {
            return 0;
        }

        int res = func_recursion(i + 1, k, piles), cur = 0;

        for (int j = 0; j < piles.get(i).size() && j < k; ++j) {
            cur += piles.get(i).get(j);
            res = Math.max(res, func_recursion(i + 1, k - j - 1, piles) + cur);
        }

        return res;
    }

    public static int func_dp(int i, int k, List<List<Integer>> piles, int[][] dp) {
        if (dp[i][k] > 0) {
            return dp[i][k];
        }

        if (i == piles.size() || k == 0) {
            return 0;
        }

        int res = func_dp(i + 1, k, piles, dp), cur = 0;

        for (int j = 0; j < piles.get(i).size() && j < k; ++j) {
            cur += piles.get(i).get(j);
            res = Math.max(res, func_dp(i + 1, k - j - 1, piles, dp) + cur);
        }

        dp[i][k] = res;
        return res;
    }

}
