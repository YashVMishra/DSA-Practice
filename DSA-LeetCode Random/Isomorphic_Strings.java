// https://leetcode.com/problems/isomorphic-strings/description/?envType=daily-question&envId=2024-04-02

import java.util.Arrays;
import java.util.HashMap;

public class Isomorphic_Strings {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphic_2(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            ans = ans + map.get(s.charAt(i));
        }

        if (ans.equals(t)) {
            return true;
        }

        return false;
    }

    // -----------------------------------------------------------------------------------

    public static boolean isIsomorphic_2(String s, String t) {
        int[] mp1 = new int[256];
        int[] mp2 = new int[256];
        Arrays.fill(mp1, -1);
        Arrays.fill(mp2, -1);
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if ((mp1[ch1] != -1 && mp1[ch1] != ch2) || (mp2[ch2] != -1 && mp2[ch2] != ch1))
                return false;

            mp1[ch1] = ch2;
            mp2[ch2] = ch1;
        }

        return true;
    }
}
