//https://leetcode.com/problems/merge-strings-alternately/description/

public class Merge_Strings_Alternately {
    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        System.out.println(mergeAlternately(word1, word2));
        System.out.println(mergeAlternately_2(word1, word2));
    }

    // own build logic.
    // run the loop till the shorter string and then append the
    // substring from the bigger one.
    public static String mergeAlternately(String word1, String word2) {
        int min_len = Math.min(word1.length(), word2.length());
        String ans = "";

        for (int i = 0; i < min_len; i++) {
            ans = ans + word1.charAt(i);
            ans = ans + word2.charAt(i);
        }

        if (word1.length() > min_len) {
            ans = ans + word1.substring(min_len);
        }

        if (word2.length() > min_len) {
            ans = ans + word2.substring(min_len);
        }

        return ans;
    }

    // logic according to the hint given in the problem.
    public static String mergeAlternately_2(String word1, String word2) {
        String ans = "";
        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()) {
            ans = ans + word1.charAt(i);
            ans = ans + word2.charAt(j);
            i++;
            j++;
        }

        if (i < word1.length()) {
            ans = ans + word1.substring(i);
        }

        if (j < word2.length()) {
            ans = ans + word2.substring(j);
        }

        return ans;
    }
}
