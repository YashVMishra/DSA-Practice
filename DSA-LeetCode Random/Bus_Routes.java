// https://leetcode.com/problems/bus-routes/description/?envType=daily-question&envId=2023-11-12

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Bus_Routes {
    public static void main(String[] args) {
        int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
        int source = 1;
        int target = 6;

        System.out.println(numBusesToDestination(routes, source, target));
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        // Create a map from the bus stop to all the routes that include this stop.
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                adj.putIfAbsent(stop, new ArrayList<>());
                adj.get(stop).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[501];

        // Insert all the routes in the queue that have the source stop.
        for (int route : adj.getOrDefault(source, new ArrayList<>())) {
            q.add(route);
            visited[route] = true;
        }

        int busCount = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int route = q.poll();

                // Iterate over the stops in the current route.
                for (int stop : routes[route]) {

                    // Return the current count if the target is found.
                    if (stop == target) {
                        return busCount;
                    }

                    // Iterate over the next possible routes from the current stop.
                    for (int nextRoute : adj.getOrDefault(stop, new ArrayList<>())) {
                        if (!visited[nextRoute]) {
                            visited[nextRoute] = true;
                            q.add(nextRoute);
                        }
                    }
                }
            }

            busCount++;
        }

        return -1;
    }
}
