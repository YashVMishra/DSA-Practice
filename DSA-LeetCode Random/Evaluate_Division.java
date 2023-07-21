//https://leetcode.com/problems/evaluate-division/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Evaluate_Division {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = { 2.0, 3.0 };

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "c"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] ans = new double[queries.size()];
        int index = 0;

        for (List<String> query : queries) {
            Set<String> visited = new HashSet<>();

            if (query.get(0).equals(query.get(1))) {
                if (graph.containsKey(query.get(0))) {
                    ans[index] = 1.0;
                    index++;
                }

                else {
                    ans[index] = -1.0;
                    index++;
                }

                continue;
            }

            double res = dfs(query.get(0), query.get(1), graph, visited);
            ans[index] = res;
            index++;
        }

        return ans;
    }

    // graph building.
    public static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int index = 0;

        for (List<String> equation : equations) {
            String start = equation.get(0);
            String end = equation.get(1);
            double value = values[index];
            index++;

            graph.putIfAbsent(start, new HashMap<>());
            graph.get(start).put(end, value);

            graph.putIfAbsent(end, new HashMap<>());
            graph.get(end).put(start, 1 / value);
        }

        return graph;
    }

    // dfs traversal.
    public static double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        Map<String, Double> startMap = graph.get(start);
        for (Map.Entry<String, Double> entry : startMap.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                double currVal = dfs(entry.getKey(), end, graph, visited);

                if (currVal != -1) {
                    return currVal * entry.getValue();
                }
            }
        }

        return -1.0;

    }
}
