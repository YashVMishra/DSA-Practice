// https://leetcode.com/problems/find-common-characters/description/?envType=daily-question&envId=2024-06-05

import java.util.ArrayList;
import java.util.List;

public class Find_Common_Characters {
    public static void main(String[] args) {
        String[] words = { "bella", "label", "roller" };
        List<String> result = commonChars(words);
        System.out.println(result);
    }

    public static List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        int n = words.length;

        // Initialize the count array for the first word
        int[] count = new int[26];
        fillCountArray(words[0], count);

        // Iterate through the rest of the words and update the count array
        for (int i = 1; i < n; i++) {
            int[] temp = new int[26];
            fillCountArray(words[i], temp);

            for (int j = 0; j < 26; j++) {
                count[j] = Math.min(count[j], temp[j]);
            }
        }

        // Collect the common characters based on the count array
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    result.add(String.valueOf((char) (i + 'a')));
                }
            }
        }

        return result;
    }

    public static void fillCountArray(String word, int[] count) {
        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }
    }
}