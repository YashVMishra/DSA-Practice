// https://leetcode.com/problems/parallel-courses-iii/description/?envType=daily-question&envId=2023-10-18

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Parallel_Courses_3 {
    public static void main(String[] args) {
        int n = 5;
        int[][] relations = { { 1, 5 }, { 2, 5 }, { 3, 5 }, { 3, 4 }, { 4, 5 } };
        int[] time = { 1, 2, 3, 4, 5 };

        System.out.println(minimumTime(n, relations, time));
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[n];
        int[] maxTime = new int[n];

        // forming the adjacency list and inDegree array.
        for (int[] arr : relations) {
            int u = arr[0] - 1;
            int v = arr[1] - 1;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            inDegree[v]++;
        }

        // inserting the nodes which have inDegree 0 into the queue.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                maxTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            List<Integer> neighbors = adj.getOrDefault(u, new ArrayList<>());

            for (int v : neighbors) {
                maxTime[v] = Math.max(maxTime[v], maxTime[u] + time[v]);
                inDegree[v]--;

                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        int result = 0;
        for (int i : maxTime) {
            result = Math.max(result, i);
        }

        return result;
    }
}
