//https://leetcode.com/problems/is-subsequence/description/?envType=study-plan&id=level-1

public class Is_Subsequence {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int tpos = 0;

        for (int i = 0; i < s.length(); i++) {
            while (tpos < t.length() && t.charAt(tpos) != s.charAt(i)) {
                tpos += 1;
            }

            if (tpos >= t.length()) {
                return false;
            }

            tpos += 1;
        }

        return true;
    }

}
