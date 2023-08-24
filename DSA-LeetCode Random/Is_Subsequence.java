//https://leetcode.com/problems/is-subsequence/description/?envType=study-plan&id=level-1

public class Is_Subsequence {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    // keep two pointers and compare the characters at the pointers
    // update both pointers if the characters are equal else update only
    // the main string pointer and later check for the condition in the
    // if statement.
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (i == s.length()) {
            return true;
        }

        return false;
    }

    // same idea just different application.
    public static boolean isSubsequence_2(String s, String t) {
        int tpos = 0;

        for (int i = 0; i < s.length(); i++) {
            while (tpos < t.length() && s.charAt(i) != t.charAt(tpos)) {
                tpos++;
            }

            if (tpos >= t.length()) {
                return false;
            }

            tpos++;
        }

        return true;
    }
}
