//https://leetcode.com/problems/valid-anagram/submissions/

class Valid_Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        else {
            int[] char_count = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char_count[s.charAt(i) - 'a']++;
                char_count[t.charAt(i) - 'a']--;
            }

            for (int i : char_count) {
                if (i != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}