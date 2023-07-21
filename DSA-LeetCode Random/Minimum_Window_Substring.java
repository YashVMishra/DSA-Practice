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

        HashMap<Character, Integer> t_map = new HashMap<>();
        HashMap<Character, Integer> s_map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            t_map.put(t.charAt(i), t_map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int match_count = 0;
        int desired_count = t.length();
        int i = -1;
        int j = -1;
        String ans = "";

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // acquire
            while (i < s.length() - 1 && match_count < desired_count) {
                i++;
                char ch = s.charAt(i);
                s_map.put(ch, s_map.getOrDefault(ch, 0) + 1);

                if (t_map.getOrDefault(ch, 0) <= s_map.getOrDefault(ch, 0)) {
                    match_count++;
                }

                f1 = true;
            }

            // collect and release
            while (j < i && match_count == desired_count) {
                String subString = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || ans.length() > subString.length()) {
                    ans = subString;
                }

                j++;
                char ch = s.charAt(j);

                if (s_map.get(ch) == 1) {
                    s_map.remove(ch);
                } else {
                    s_map.put(ch, s_map.get(ch) - 1);
                }

                if (s_map.getOrDefault(ch, 0) < t_map.getOrDefault(ch, 0)) {
                    match_count--;
                }

                f2 = true;
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }
}
