//https://leetcode.com/problems/word-break/description/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Word_Break {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("aaaa", "aaa"));
        System.out.println(wordBreak("aaaaaaa", list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];

        return compute(s, wordDict, 0, memo);
    }

    public static boolean compute(String s, List<String> dict, int pos, Boolean[] memo) {
        if (pos == s.length())
            return true;

        if (memo[pos] != null)
            return memo[pos];

        StringBuilder sb = new StringBuilder(s);

        for (int i = pos + 1; i <= s.length(); i++) {
            String str = sb.substring(pos, i);

            if (dict.contains(str) && compute(s, dict, i, memo)) {
                memo[pos] = true;
                return true;
            }
        }

        memo[pos] = false;
        return false;
    }
}
