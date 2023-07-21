//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan&id=level-2

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

        // create a HashSet to keep the characters in it.
        HashSet<Character> set = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int len = s.length();

        while (right < len) {

            // if the set contains the character, remove the character from the left
            // till the character at right is not present in the set.
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // if no new element is found just add them to the set.
            else {
                set.add(s.charAt(right));

                // you have to calculate this here, not outside because if you calculate it
                // outside the value of right will increase by one and that will increase our
                // ans by 1.
                ans = Math.max(ans, right - left + 1);
                right++;
            }
        }

        return ans;
    }
}
