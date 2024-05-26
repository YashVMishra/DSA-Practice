// https://leetcode.com/problems/word-break-ii/description/?envType=daily-question&envId=2024-05-25

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Break_2 {
    private static List<String> result;
    private static Set<String> dict;

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        dict = new HashSet<>(wordDict);

        String currSentence = "";
        solve(0, currSentence, s);

        return result;
    }

    private static void solve(int i, String currSentence, String s) {
        if (i >= s.length()) {
            result.add(currSentence.trim());
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String tempWord = s.substring(i, j + 1);

            if (dict.contains(tempWord)) {
                String originalSentence = currSentence;
                if (!currSentence.isEmpty()) {
                    currSentence += " ";
                }
                currSentence += tempWord;

                solve(j + 1, currSentence, s);

                currSentence = originalSentence;
            }
        }
    }
}