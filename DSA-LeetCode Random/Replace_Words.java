// https://leetcode.com/problems/replace-words/description/?envType=daily-question&envId=2024-06-07

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Replace_Words {
    public static void main(String[] args) {
        List<String> dictionary = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String result = replaceWords(dictionary, sentence);
        System.out.println(result);
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        Set<String> st = new HashSet<>(dictionary);

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String word : words) {
            result.append(findRoot(word, st)).append(" ");
        }

        // Remove the trailing space
        return result.toString().trim();
    }

    private static String findRoot(String word, Set<String> st) {
        // Try all length substring starting from 0th index
        for (int l = 1; l <= word.length(); l++) {
            String root = word.substring(0, l);
            if (st.contains(root)) {
                return root;
            }
        }

        return word;
    }
}
