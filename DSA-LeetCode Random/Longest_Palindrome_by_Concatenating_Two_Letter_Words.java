//https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/?envType=study-plan&id=level-2

import java.util.HashMap;
import java.util.Map;

public class Longest_Palindrome_by_Concatenating_Two_Letter_Words {
    public static void main(String[] args) {
        String[] words = { "ab", "ty", "yt", "lc", "cl", "ab" };
        System.out.println(longestPalindrome(words));
    }

    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int ans = 0;

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String key = e.getKey();
            String rev = reverse(key);

            if (map.containsKey(rev)) {
                if (rev.equals(key)) {
                    int val = map.get(key);
                    if (map.get(rev) % 2 != 0) {
                        val--;
                    }

                    ans += 2 * val;
                    map.replace(key, map.get(key) - val);
                }

                else {
                    int min = Math.min(map.get(key), map.get(rev));
                    ans += 4 * min;
                    map.replace(key, map.get(key) - min);
                    map.replace(rev, map.get(rev) - min);
                }
            }
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String key = e.getKey();
            int val = e.getValue();

            if (key.charAt(0) == key.charAt(1) && val > 0) {
                ans += 2;
                break;
            }
        }

        return ans;
    }

    public static String reverse(String str) {
        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            ans = str.charAt(i) + ans;
        }

        return ans;
    }
}
