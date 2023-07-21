import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int len = s.length();

        while (right < len) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
        }

        return maxLen;
    }
}
