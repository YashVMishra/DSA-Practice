//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reorder_Routes_to_Make_All_Paths_Lead_to_City_Zero {

    static int count = 0;

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        System.out.println(minReorder(n, connections));
    }

    public static void dfs(int node, int parent, Map<Integer, List<List<Integer>>> adj) {
        if (!adj.containsKey(node)) {
            return;
        }

        for (List<Integer> nei : adj.get(node)) {
            int child = nei.get(0);
            int sign = nei.get(1);

            if (child != parent) {
                count += sign;
                dfs(child, node, adj);
            }
        }
    }

    public static int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();

        for (int[] connection : connections) {

            adj.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>())
                    .add(Arrays.asList(connection[1], 1));

            adj.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>())
                    .add(Arrays.asList(connection[0], 0));

        }

        dfs(0, -1, adj);
        return count;
    }

}
