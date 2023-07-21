//https://leetcode.com/problems/smallest-sufficient-team/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Smallest_Sufficient_Team {

    static int[][] dp;
    static boolean[][] choice;
    static int req_mask, m;

    public static void main(String[] args) {
        String[] req_skills = { "java", "nodejs", "reactjs" };
        List<List<String>> people = new ArrayList<>();
        people.add(Arrays.asList("java"));
        people.add(Arrays.asList("nodejs"));
        people.add(Arrays.asList("nodejs", "reactjs"));

        System.out.println(Arrays.toString(smallestSufficientTeam(req_skills, people)));
    }

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people_skills) {
        int n = req_skills.length;
        m = people_skills.size();

        Map<String, Integer> skills = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skills.put(req_skills[i], i);
        }

        List<Integer> people = new ArrayList<>();
        for (List<String> v : people_skills) {
            int h = 0;

            for (String skill : v) {
                h |= 1 << skills.get(skill);
            }

            people.add(h);
        }

        req_mask = (1 << n) - 1;
        dp = new int[1 << 16][64];
        choice = new boolean[1 << 16][64];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        solve(people, 0, 0);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0, mask = 0; i < m; i++) {
            if (choice[mask][i]) {
                ans.add(i);
                mask |= people.get(i);
            }

            if (mask == req_mask) {
                break;
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public static int solve(List<Integer> people, int i, int mask) {
        if (mask == req_mask)
            return 0;

        if (i == m)
            return 10000;

        if (dp[mask][i] != -1)
            return dp[mask][i];

        int ans1 = solve(people, i + 1, mask | people.get(i)) + 1;
        int ans2 = solve(people, i + 1, mask);

        if (ans1 < ans2) {
            choice[mask][i] = true;
        }

        return dp[mask][i] = Math.min(ans1, ans2);
    }
}
