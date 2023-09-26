// https://leetcode.com/problems/remove-duplicate-letters/description/?envType=daily-question&envId=2023-09-26

// same as LeetCode 316. Remove Duplicate Letters
public class Remove_Duplicate_Letters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visited[s.charAt(i) - 'a']) {
                char ch = s.charAt(i);
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch
                        && lastIndex[sb.charAt(sb.length() - 1) - 'a'] > i) {
                    visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }

                visited[ch - 'a'] = true;
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
