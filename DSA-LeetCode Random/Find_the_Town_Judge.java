// https://leetcode.com/problems/find-the-town-judge/description/?envType=daily-question&envId=2024-02-22

public class Find_the_Town_Judge {
    public static void main(String[] args) {
        int n = 4;
        int[][] trust = new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        System.out.println(findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];

        for (int[] t : trust) {
            int oneWhoIsTrusting = t[0];
            int oneWhoIsTrusted = t[1];

            trustCount[oneWhoIsTrusting]--;
            trustCount[oneWhoIsTrusted]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
