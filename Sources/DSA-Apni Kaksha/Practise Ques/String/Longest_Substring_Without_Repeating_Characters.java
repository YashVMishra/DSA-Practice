import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        int len = 0;
        int left = 0;
        int right = 0;
        int n = s.length();

        while (right < n) {
            if (mp.containsKey(s.charAt(right))) {
                left = Math.max(mp.get(s.charAt(right)) + 1, left);
            }

            mp.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }

        return len;
    }
}
