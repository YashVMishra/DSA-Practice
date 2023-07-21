//https://leetcode.com/problems/scramble-string/description/

import java.util.HashMap;
import java.util.Map;

public class Scramble_Strings {

    static Map<String, Boolean> mp = new HashMap<>();

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s1.equals(s2))
            return true;

        if (n == 1)
            return false;

        String key = s1 + " " + s2;

        if (mp.containsKey(key))
            return mp.get(key);

        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                mp.put(key, true);
                return true;
            }

            if (isScramble(s1.substring(0, i), s2.substring(n - i))
                    && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                mp.put(key, true);
                return true;
            }
        }

        mp.put(key, false);
        return false;
    }

}
