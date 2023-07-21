//https://leetcode.com/problems/time-needed-to-inform-all-employees/description/

import java.util.ArrayList;
import java.util.HashMap;

public class Time_Needed_to_Inform_All_Employees {

    static HashMap<Integer, ArrayList<Integer>> map;
    static int ans = 0, mx = 0;

    public static void main(String[] args) {
        int n = 6;
        int headID = 2;
        int[] manager = { 2, 2, -1, 2, 2, 2 };
        int[] informTime = { 0, 0, 1, 0, 0, 0 };
        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        map = new HashMap<>();

        // Fill map
        for (int i = 0; i < n; i++) {
            int val = manager[i];
            if (val != -1) {
                map.putIfAbsent(val, new ArrayList<>());
                map.get(val).add(i);
            }
        }

        dfs(headID, informTime);
        return mx;
    }

    public static void dfs(int manager, int[] informTime) {
        mx = Math.max(mx, ans);
        for (int employee : map.getOrDefault(manager, new ArrayList<>())) {
            ans += informTime[manager];

            dfs(employee, informTime);

            ans -= informTime[manager];
        }
    }
}
