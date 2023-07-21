//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// For reference watch the video
// https://www.youtube.com/watch?v=qOPxRziTxEQ

import java.util.HashMap;
import java.util.HashSet;

public class Longest_K_unique_characters_substring {
    public static void main(String[] args) {
        String S = "aabacbebebe";
        int K = 3;
        System.out.println(longestkSubstr(S, K));
    }

    public static int longestkSubstr(String s, int k) {
        // code here

        // checking for more than K distinct characters
        HashSet<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        if (set.size() > k) {
            return -1;
        }

        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < s.length() - 1) {
                f1 = true;
                i++;
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

                if (map.size() <= k) {
                    ans = Math.max(ans, i - j);
                } else {
                    break;
                }
            }

            while (j < i) {
                j++;
                f2 = true;

                if (map.get(s.charAt(j)) == 1) {
                    map.remove(s.charAt(j));
                } else {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                }

                if (map.size() > k) {
                    continue;
                } else {
                    ans = Math.max(ans, i - j);
                    break;
                }
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }
}
