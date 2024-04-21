// https://leetcode.com/problems/find-if-path-exists-in-graph/description/?envType=daily-question&envId=2024-04-21

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Find_if_Path_Exists_in_Graph {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        int source = 0;
        int destination = 2;

        System.out.println(validPath(n, edges, source, destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int[] vec : edges) {
            int u = vec[0];
            int v = vec[1];

            mp.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            mp.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];
        return check(mp, source, destination, visited);
    }

    public static boolean check(Map<Integer, List<Integer>> mp, int node, int dest, boolean[] visited) {
        if (node == dest)
            return true;

        if (visited[node])
            return false;

        visited[node] = true;
        for (int it : mp.getOrDefault(node, new ArrayList<>())) {
            if (check(mp, it, dest, visited))
                return true;
        }
        return false;
    }

    // --------------------------------------------------------------------------------

    public static boolean validPath_2(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int[] vec : edges) {
            int u = vec[0];
            int v = vec[1];

            mp.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            mp.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> que = new LinkedList<>();
        que.offer(source);
        visited[source] = true;

        while (!que.isEmpty()) {
            int node = que.poll();
            if (node == destination)
                return true;

            for (int it : mp.getOrDefault(node, new ArrayList<>())) {
                if (!visited[it]) {
                    visited[it] = true;
                    que.offer(it);
                }
            }
        }

        return false;
    }
}
