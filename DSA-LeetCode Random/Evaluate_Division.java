// https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Pair {
    String first;
    double second;

    Pair(String first, double second) {
        this.first = first;
        this.second = second;
    }
}

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
        int n = equations.size();

        Map<String, List<Pair>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new Pair(v, val)); // To handle a/c
            adj.get(v).add(new Pair(u, 1.0 / val)); // To handle c/a
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);

            String src = query.get(0);
            String dst = query.get(1);

            double[] ans = { -1.0 };
            double product = 1.0;

            if (adj.containsKey(src)) {
                Set<String> visited = new HashSet<>();

                dfs(adj, src, dst, visited, product, ans);
            }

            result[i] = ans[0];
        }

        return result;
    }

    public static void dfs(Map<String, List<Pair>> adj, String src, String dst, Set<String> visited, double product,
            double[] ans) {
        if (visited.contains(src)) {
            return;
        }

        visited.add(src);
        if (src.equals(dst)) {
            ans[0] = product;
            return;
        }

        for (Pair p : adj.get(src)) {
            String v = p.first;
            double val = p.second;

            dfs(adj, v, dst, visited, product * val, ans);
        }
    }
}
