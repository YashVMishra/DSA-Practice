//https://leetcode.com/problems/find-eventual-safe-states/description/ 

import java.util.ArrayList;
import java.util.List;

public class Find_Eventual_Safe_States {
    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();

        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] dfsVisited = new boolean[n];
        boolean[] presentCycle = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFSRec(i, visited, dfsVisited, graph, presentCycle);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!presentCycle[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static boolean DFSRec(int s, boolean[] visited, boolean[] dfsVisited, int[][] graph,
            boolean[] presentCycle) {
        visited[s] = true;
        dfsVisited[s] = true;

        int[] data = graph[s];
        for (int x : data) {
            if (!visited[x]) {
                if (DFSRec(x, visited, dfsVisited, graph, presentCycle)) {
                    presentCycle[s] = true;
                    return true;
                }
            } else if (visited[x] && dfsVisited[x]) {
                presentCycle[s] = true;
                return true;
            }
        }

        dfsVisited[s] = false;
        return false;
    }
}
