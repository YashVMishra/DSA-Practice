//https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1

public class Count_Palindromic_Subsequence {
    public static void main(String[] args) {
        String str = "aaa";
        long[][] dp = new long[1000][1000];
        int n = str.length();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                dp[i][j] = -1;
            }

        }

        System.out.println(helper(str, 0, n - 1, dp));
    }

    // uses the dp array to keep the track of the palindromes which have already
    // occured
    // other way is to find all the subsequneces but the complexity will be bad.
    public static long helper(String str, int i, int j, long[][] dp) {

        if (dp[i][j] != -1)
            return dp[i][j];

        int mod = (int) Math.pow(10, 9) + 7;

        if (i > j) {

            return 0;
        }
        if (i == j)
            return dp[i][j] = 1;

        else if (str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = (1 + helper(str, i + 1, j, dp) + helper(str, i, j - 1, dp)) % mod;
        }

        else {
            return dp[i][j] = (mod + helper(str, i + 1, j, dp) + helper(str, i, j - 1, dp)
                    - helper(str, i + 1, j - 1, dp)) % mod;
        }

    }
}
