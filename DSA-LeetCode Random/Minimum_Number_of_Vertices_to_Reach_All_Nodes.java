//https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Number_of_Vertices_to_Reach_All_Nodes {
    public static void main(String[] args) {
        int n = 5;
        int[][] temp = { { 0, 1 }, { 2, 1 }, { 3, 1 }, { 1, 4 }, { 2, 4 } };
        List<List<Integer>> edges = new ArrayList<>();

        for (int[] arr : temp) {
            edges.add(Arrays.asList(arr[0], arr[1]));
        }

        System.out.println(findSmallestSetOfVertices(n, edges));
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];

        // calculating the indegree of every node.
        for (List<Integer> e : edges) {
            inDegree[e.get(1)]++;
        }

        // taking nodes that have indegree as zero.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}
