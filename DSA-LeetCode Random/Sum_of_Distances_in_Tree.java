// https://leetcode.com/problems/sum-of-distances-in-tree/description/?envType=daily-question&envId=2024-04-28

import java.util.*;

public class Sum_of_Distances_in_Tree {
    static long resultBaseNode = 0;
    static int[] count;
    static int N;

    public static void main(String[] args) {
        int N = 6;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
        System.out.println(Arrays.toString(sumOfDistancesInTree(N, edges)));
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        N = n;
        count = new int[n];
        for (int[] vec : edges) {
            int u = vec[0];
            int v = vec[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        resultBaseNode = 0;
        dfsBase(adj, 0, -1, 0);
        int[] result = new int[n];
        result[0] = (int) resultBaseNode;
        DFS(adj, 0, -1, result);
        return result;
    }

    public static void DFS(HashMap<Integer, ArrayList<Integer>> adj, int parentNode, int prevNode, int[] result) {
        for (int child : adj.getOrDefault(parentNode, new ArrayList<>())) {
            if (child == prevNode)
                continue;

            result[child] = result[parentNode] - count[child] + (N - count[child]);
            DFS(adj, child, parentNode, result);
        }
    }

    public static int dfsBase(HashMap<Integer, ArrayList<Integer>> adj, int currNode, int prevNode, int currDepth) {
        int totalNode = 1;
        resultBaseNode += currDepth;

        // adjusting the for loop for null pointer exception
        for (int child : adj.getOrDefault(currNode, new ArrayList<>())) {
            if (child == prevNode)
                continue;

            totalNode += dfsBase(adj, child, currNode, currDepth + 1);
        }

        count[currNode] = totalNode;
        return totalNode;
    }
}
