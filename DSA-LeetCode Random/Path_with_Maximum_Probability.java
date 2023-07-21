//https://leetcode.com/problems/path-with-maximum-probability/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.AbstractMap;

public class Path_with_Maximum_Probability {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = { 0.5, 0.5, 0.2 };
        int start = 0, end = 2;
        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double ans = 0;
        PriorityQueue<Map.Entry<Double, Integer>> q = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getKey(), a.getKey()));

        q.offer(new AbstractMap.SimpleEntry<>(1.0, start));
        List<Map.Entry<Integer, Double>>[] adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adj[u].add(new AbstractMap.SimpleEntry<>(v, w));
            adj[v].add(new AbstractMap.SimpleEntry<>(u, w));

        }

        double[] probability = new double[n];
        probability[start] = 1;

        while (!q.isEmpty()) {
            int pos = q.peek().getValue();
            double cnt = q.poll().getKey();

            if (pos == end) {
                ans = Math.max(ans, cnt);
            }

            for (Map.Entry<Integer, Double> it : adj[pos]) {
                int neighbor = it.getKey();
                double weight = it.getValue();

                if (cnt * weight > probability[neighbor]) {
                    probability[neighbor] = cnt * weight;
                    q.offer(new AbstractMap.SimpleEntry<>(probability[neighbor], neighbor));

                }
            }
        }

        return ans;
    }
}
