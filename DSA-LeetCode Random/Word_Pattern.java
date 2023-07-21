//https://leetcode.com/problems/word-pattern/description/

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Word_Pattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abaa", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {

        // to store the words of the string.
        ArrayList<String> list = new ArrayList<>();

        String str = s + " ";
        String temp_str = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ' ') {
                temp_str = temp_str + ch;
            }

            else {
                list.add(temp_str);
                temp_str = "";
            }
        }

        // if size of list and size of pattern does not match then mapping cannot be
        // done so return false immediately
        if (pattern.length() != list.size()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i)) == false) {
                if (map.containsValue(list.get(i)) == false) {
                    map.put(pattern.charAt(i), list.get(i));
                }

                else {
                    return false;
                }
            }

            else {
                if (map.get(pattern.charAt(i)).equals(list.get(i))) {
                    ;
                }

                else {
                    return false;
                }
            }
        }

        return true;
    }
}
