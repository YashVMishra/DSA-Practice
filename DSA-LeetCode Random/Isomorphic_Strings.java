//https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan&id=level-1

import java.util.HashMap;

public class Isomorphic_Strings {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
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
}
