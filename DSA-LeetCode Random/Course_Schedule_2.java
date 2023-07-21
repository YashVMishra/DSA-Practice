//https://leetcode.com/problems/course-schedule-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Course_Schedule_2 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    // Graph coloring: 0->not visited...1->visited...2->visited & processed
    public static boolean detectCycle_util(List<List<Integer>> adj, int[] visited, int v) {
        if (visited[v] == 1)
            return true;

        if (visited[v] == 2)
            return false;

        visited[v] = 1; // Mark current as visited

        for (int i = 0; i < adj.get(v).size(); ++i)
            if (detectCycle_util(adj, visited, adj.get(v).get(i))) {
                return true;
            }

        visited[v] = 2; // Mark current node as processed
        return false;
    }

    // Cycle detection
    public static boolean detectCycle(List<List<Integer>> adj, int n) {
        int[] visited = new int[n];
        Arrays.fill(visited, 0);

        for (int i = 0; i < n; ++i)
            if (visited[i] == 0) {
                if (detectCycle_util(adj, visited, i)) {
                    return true;
                }
            }

        return false;
    }

    // Topological sort
    public static void dfs(List<List<Integer>> adj, int v, boolean[] visited, Stack<Integer> mystack) {
        visited[v] = true;

        for (int i = 0; i < adj.get(v).size(); ++i)
            if (!visited[adj.get(v).get(i)]) {
                dfs(adj, adj.get(v).get(i), visited, mystack);
            }

        mystack.push(v);
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Make adjacecncy list
        for (int i = 0; i < n; ++i) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Detect CYCLE...If present then return empty array
        int[] ans = new int[numCourses];
        if (detectCycle(adj, numCourses)) {
            return new int[] {};
        }

        // Find toposort and store it in stack
        Stack<Integer> mystack = new Stack<>();
        boolean[] visited = new boolean[numCourses];

        // Apply DFS and find topological sort
        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i]) {
                dfs(adj, i, visited, mystack);
            }
        }

        int i = 0;
        while (!mystack.empty()) {
            ans[i++] = mystack.pop();
        }

        return ans;
    }
}
