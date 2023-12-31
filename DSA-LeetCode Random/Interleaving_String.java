// https://leetcode.com/problems/interleaving-string/description/

import java.util.HashMap;
import java.util.Map;

public class Interleaving_String {
    public static void main(String[] args) {
        String s1 = "a", s2 = "b", s3 = "a";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        return isInterleaving(s1, s2, s3, new HashMap<>());
    }

    private static boolean isInterleaving(String a, String b, String c, Map<String, Boolean> map) {
        if (a.length() + b.length() != c.length())
            return false;
        if (a.isEmpty() && b.isEmpty() && c.isEmpty())
            return true;

        String key = a + "->" + b + "->" + c;
        boolean resultOne = false;
        boolean resultTwo = false;

        if (!map.containsKey(key)) {
            if (!a.isEmpty() && a.charAt(0) == c.charAt(0))
                resultOne = isInterleaving(a.substring(1), b, c.substring(1), map);

            if (!b.isEmpty() && b.charAt(0) == c.charAt(0))
                resultTwo = isInterleaving(a, b.substring(1), c.substring(1), map);
            map.put(key, resultOne || resultTwo);
        }

        return map.get(key);
    }
}
