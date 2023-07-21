//https://leetcode.com/problems/longest-repeating-character-replacement/description/?envType=study-plan&id=level-1

public class Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int max_length = 0;
        int left = 0;
        int right = 0;
        int[] counts = new int[26];

        for (int i = right; i < s.length(); i++) {
            counts[s.charAt(i) - 'A']++;

            int most_frequent = max(counts);

            if (((i - left + 1) - most_frequent) <= k) {
                max_length = Math.max(max_length, i - left + 1);
            }

            else {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return max_length;
    }

    public static int max(int[] counts) {
        int max = 0;

        for (int i : counts) {
            max = Math.max(max, i);
        }

        return max;
    }
}
