// https://leetcode.com/problems/maximal-network-rank/description/

public class Maximal_Network_Rank {
    public static void main(String[] args) {
        int[][] roads = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        System.out.println(maximalNetworkRank(4, roads));
        System.out.println(maximalNetworkRank_2(4, roads));
    }

    // brute force approach but it works as constraints are small
    public static int maximalNetworkRank(int n, int[][] roads) {
        int rank = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;

                for (int[] road : roads) {
                    if (road[0] == i || road[1] == i || road[0] == j || road[1] == j) {
                        count++;
                    }
                }

                rank = Math.max(count, rank);
            }
        }

        return rank;
    }

    // better solution.
    public static int maximalNetworkRank_2(int n, int[][] roads) {

        // count the number of roads connected to each city.
        int[] count = new int[n];

        // for directly connected cities, mark the entry as 1.
        int[][] direct = new int[n][n];

        // pre-processing
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;

            // for directly connected components.
            // imp lines.
            direct[road[0]][road[1]] = 1;
            direct[road[1]][road[0]] = 1;
        }

        int rank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                rank = Math.max(rank, count[i] + count[j] - direct[i][j]);
            }
        }

        return rank;
    }
}
