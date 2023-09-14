// https://leetcode.com/problems/reconstruct-itinerary/description/?envType=daily-question&envId=2023-09-14

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Reconstruct_Itinerary {
    static Map<String, PriorityQueue<String>> adj;
    static List<String> result;
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        result = new ArrayList<>();

        // Build the adjacency list
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    private static void dfs(String u) {
        PriorityQueue<String> edges = adj.get(u);
        while (edges != null && !edges.isEmpty()) {
            String v = edges.poll();
            dfs(v);
        }

        result.add(u);
    }
}
