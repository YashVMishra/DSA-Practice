// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/?envType=daily-question&envId=2024-02-23

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Cheapest_Flights_Within_K_Stops {
    public static void main(String[] args) {
        int n = 3;
        int[][] flights = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        int src = 0;
        int dst = 2;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[] { v, cost });
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { src, 0 });
        distance[src] = 0;

        int level = 0;

        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int u = current[0];
                int d = current[1];

                List<int[]> neighbors = adj.getOrDefault(u, Collections.emptyList());
                for (int[] neighbor : neighbors) {
                    int v = neighbor[0];
                    int cost = neighbor[1];

                    if (distance[v] > d + cost) {
                        distance[v] = d + cost;
                        queue.offer(new int[] { v, d + cost });
                    }
                }
            }

            level++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
