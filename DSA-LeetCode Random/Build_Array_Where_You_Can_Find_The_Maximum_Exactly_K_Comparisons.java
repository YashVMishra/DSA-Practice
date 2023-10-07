// https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/description/?envType=daily-question&envId=2023-10-07

import java.util.Arrays;

public class Build_Array_Where_You_Can_Find_The_Maximum_Exactly_K_Comparisons {
    static int N, M, K;
    static int MOD = (int) (1e9 + 7);
    static int t[][][];

    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int k = 1;
        System.out.println(numOfArrays(n, m, k));
    }

    public static int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        t = new int[51][51][101];
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }
        return solve(0, 0, 0);
    }

    private static int solve(int idx, int searchCost, int maxSoFar) {
        if (idx == N) {
            if (searchCost == K) {
                return 1;
            }
            return 0;
        }

        if (t[idx][searchCost][maxSoFar] != -1) {
            return t[idx][searchCost][maxSoFar];
        }

        int result = 0;

        for (int i = 1; i <= M; i++) {
            if (i > maxSoFar) {
                result = (result + solve(idx + 1, searchCost + 1, i)) % MOD;
            } else {
                result = (result + solve(idx + 1, searchCost, maxSoFar)) % MOD;
            }
        }

        return t[idx][searchCost][maxSoFar] = result % MOD;
    }
}
