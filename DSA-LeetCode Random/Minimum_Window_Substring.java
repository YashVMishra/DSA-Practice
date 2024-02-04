// https://leetcode.com/problems/minimum-window-substring/description/?envType=daily-question&envId=2024-02-04

import java.util.HashMap;

public class Minimum_Window_Substring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }

        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLeft = 0;
        int countRequired = t.length();
        int minWindow = Integer.MAX_VALUE;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (map.getOrDefault(ch, 0) > 0) {
                countRequired--;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while (countRequired == 0) {
                if (minWindow > right - left + 1) {
                    minWindow = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) + 1);

                if (map.get(leftChar) > 0) {
                    countRequired++;
                }

                left++;
            }

            right++;
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minWindow);
    }
}
