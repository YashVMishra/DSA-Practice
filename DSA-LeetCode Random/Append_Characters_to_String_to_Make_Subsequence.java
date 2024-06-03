// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/?envType=daily-question&envId=2024-06-03

public class Append_Characters_to_String_to_Make_Subsequence {
    public static void main(String[] args) {
        String s = "coaching", t = "coding";
        System.out.println(appendCharacters(s, t));
    }

    // just count how many letters in t are in s in the same order
    // then rest of the leters int t are the characters
    // that need to be appended.
    public static int appendCharacters(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }

            sIndex++;
        }

        return t.length() - tIndex;
    }
}
