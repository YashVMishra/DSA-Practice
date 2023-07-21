//https://leetcode.com/problems/longest-repeating-character-replacement/

public class Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        int window_start = 0;

        int max_count = 0;
        int max_length = 0;
        char[] count = new char[26];

        for (int window_end = 0; window_end < s.length(); window_end++) {
            count[s.charAt(window_end) - 'A']++;
            int current_count = count[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_count);

            // conditions gives the value of not repeating characters.
            while (window_end - window_start + 1 - max_count > k) {
                count[s.charAt(window_start) - 'A']--;
                window_start++;
            }

            max_length = Math.max(window_end - window_start + 1, max_length);
        }

        return max_length;
    }
}
