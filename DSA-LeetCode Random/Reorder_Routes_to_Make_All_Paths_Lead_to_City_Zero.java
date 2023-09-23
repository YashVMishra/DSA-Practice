// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.List;

class Pair<T, U> {
    T first;
    U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

public class Reorder_Routes_to_Make_All_Paths_Lead_to_City_Zero {
    static int count = 0;

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        System.out.println(minReorder(n, connections));
    }

    public static int minReorder(int n, int[][] connections) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new Pair<>(v, 1));
            adj.get(v).add(new Pair<>(u, 0));
        }

        boolean[] visited = new boolean[n];
        dfs_1(0, visited, adj);

        return count;
    }

    // using visited array
    public static void dfs_1(int node, boolean[] visited, List<List<Pair<Integer, Integer>>> adj) {
        visited[node] = true;

        for (Pair<Integer, Integer> p : adj.get(node)) {
            int u = p.first;
            int v = p.second;

            if (!visited[u]) {
                if (v == 1) {
                    count++;
                }

                dfs_1(u, visited, adj);
            }
        }
    }

    // using a variable as parent.
    public static void dfs_2(int node, int parent, List<List<Pair<Integer, Integer>>> adj) {
        for (Pair<Integer, Integer> p : adj.get(node)) {
            int u = p.first;
            int v = p.second;

            if (parent != u) {
                if (v == 1) {
                    count++;
                }

                dfs_2(u, node, adj);
            }
        }
    }
}
