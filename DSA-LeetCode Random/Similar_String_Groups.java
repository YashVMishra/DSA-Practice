//https://leetcode.com/problems/similar-string-groups/description/

import java.util.HashSet;

public class Similar_String_Groups {
    public static void main(String[] args) {
        String[] strs = { "tars", "rats", "arts", "star" };
        System.out.println(numSimilarGroups(strs));
    }

    public static int numSimilarGroups(String[] strs) {
        int ans = 0;

        HashSet<String> visited = new HashSet<>();

        for (String str : strs) {
            if (!visited.contains(str)) {
                dfs(strs, visited, str);
                ans++;
            }
        }

        return ans;
    }

    public static void dfs(String[] strs, HashSet<String> visited, String curr) {
        if (visited.contains(curr)) {
            return;
        }

        visited.add(curr);

        for (int i = 0; i < strs.length; i++) {
            if (isSimilar(curr, strs[i])) {
                dfs(strs, visited, strs[i]);
            }
        }
    }

    public static boolean isSimilar(String s1, String s2) {
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count > 2) {
                    return false;
                }
            }
        }

        return count == 2 || count == 0;
    }
}
