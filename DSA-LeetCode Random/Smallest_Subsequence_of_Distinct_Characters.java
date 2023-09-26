// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

// same as LeetCode 1081. Smallest Subsequence of Distinct Characters
public class Smallest_Subsequence_of_Distinct_Characters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(smallestSubsequence(s));
    }

    public static String smallestSubsequence(String s) {
        StringBuilder sb = new StringBuilder();
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visited[s.charAt(i) - 'a']) {
                char ch = s.charAt(i);

                // iterate while the last character in the stack is greater than the current
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch
                        && lastIndex[sb.charAt(sb.length() - 1) - 'a'] > i) {
                    visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }

                // important line.
                visited[ch - 'a'] = true;
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
