// https://leetcode.com/problems/number-of-music-playlists/description/

import java.util.Arrays;

public class Number_of_Music_Playlists {

    static final int MOD = 1_000_000_007;
    static Long[][] dp;

    public static void main(String[] args) {
        int n = 3, goal = 3, k = 1;
        System.out.println(numMusicPlaylists(n, goal, k));
    }

    public static int numMusicPlaylists(int n, int goal, int k) {
        dp = new Long[goal + 1][n + 1];
        for (Long[] row : dp) {
            Arrays.fill(row, -1L);
        }
        return (int) (numberOfPlaylists(goal, n, k, n));
    }

    public static long numberOfPlaylists(int i, int j, int k, int n) {
        // Base cases
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // DP transition: add a new song or replay an old one
        dp[i][j] = (numberOfPlaylists(i - 1, j - 1, k, n) * (n - j + 1)) % MOD;
        if (j > k) {
            dp[i][j] += (numberOfPlaylists(i - 1, j, k, n) * (j - k)) % MOD;
            dp[i][j] %= MOD;
        }
        return dp[i][j];
    }
}
