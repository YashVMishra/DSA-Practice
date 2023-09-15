// https://leetcode.com/problems/min-cost-to-connect-all-points/description/?envType=daily-question&envId=2023-09-15

import java.util.*;

public class Min_Cost_to_Connect_All_Points {
    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };

        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        int V = points.length;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.get(i).add(new int[] { j, d });
                adj.get(j).add(new int[] { i, d });
            }
        }

        return minMST(adj, V);
    }

    public static int minMST(List<List<int[]>> adj, int V) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // minheap

        pq.offer(new int[] { 0, 0 }); // {weight, vertex}

        boolean[] inMST = new boolean[V];
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            int wt = p[0];
            int node = p[1];

            if (inMST[node]) {
                continue;
            }

            inMST[node] = true; // added to MST
            sum += wt;

            for (int[] tmp : adj.get(node)) {
                int neighbor = tmp[0];
                int neighbor_wt = tmp[1];

                if (!inMST[neighbor]) {
                    pq.offer(new int[] { neighbor_wt, neighbor });
                }
            }
        }

        return sum;
    }
}
