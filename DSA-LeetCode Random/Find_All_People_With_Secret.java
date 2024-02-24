// https://leetcode.com/problems/find-all-people-with-secret/description/?envType=daily-question&envId=2024-02-24

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_All_People_With_Secret {
    public static void main(String[] args) {
        int n = 5;
        int[][] meetings = new int[][] { { 0, 1, 5 }, { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 } };
        int firstPerson = 0;

        List<Integer> result = findAllPeople(n, meetings, firstPerson);
        System.out.println(result);
    }

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] meeting : meetings) {
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time = meeting[2];

            adj.computeIfAbsent(person1, k -> new ArrayList<>()).add(new int[] { person2, time });
            adj.computeIfAbsent(person2, k -> new ArrayList<>()).add(new int[] { person1, time });
        }

        int[] earlySecretTime = new int[n];
        Arrays.fill(earlySecretTime, Integer.MAX_VALUE);
        earlySecretTime[0] = 0;
        earlySecretTime[firstPerson] = 0;

        // Do DFS
        dfs(0, 0, adj, earlySecretTime);
        dfs(firstPerson, 0, adj, earlySecretTime);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earlySecretTime[i] != Integer.MAX_VALUE) {
                result.add(i);
            }
        }

        return result;
    }

    private static void dfs(int person, int time, Map<Integer, List<int[]>> adj, int[] earlySecretTime) {
        for (int[] ngbr : adj.getOrDefault(person, Collections.emptyList())) {
            int nextPerson = ngbr[0];
            int t = ngbr[1];

            if (t >= time && earlySecretTime[nextPerson] > t) {
                earlySecretTime[nextPerson] = t;
                dfs(nextPerson, t, adj, earlySecretTime);
            }
        }
    }
}