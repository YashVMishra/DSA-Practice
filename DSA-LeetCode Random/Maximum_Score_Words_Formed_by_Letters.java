// https://leetcode.com/problems/maximum-score-words-formed-by-letters/description/

import java.util.Arrays;

public class Maximum_Score_Words_Formed_by_Letters {
    static int n;
    static int maxScore;

    public static void main(String[] args) {
        String[] words = { "dog", "cat", "dad", "good" };
        char[] letters = { 'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
        int[] score = { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        System.out.println(maxScoreWords(words, letters, score));
    }

    // Using simple backtracking
    // T.C : O(2^n) where n is the total number of words
    // S.C : O(n)
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for (char ch : letters) {
            freq[ch - 'a']++;
        }

        maxScore = Integer.MIN_VALUE;
        n = words.length;
        solve(0, score, words, 0, freq);

        return maxScore;
    }

    private static void solve(int i, int[] score, String[] words, int currScore, int[] freq) {
        maxScore = Math.max(maxScore, currScore);

        if (i >= n) {
            return;
        }

        int[] tempFreq = Arrays.copyOf(freq, freq.length);
        int j = 0;
        int tempScore = 0;

        while (j < words[i].length()) {
            char ch = words[i].charAt(j);

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0)
                break;

            j++;
        }

        // Take words[i]
        if (j == words[i].length()) { // It means we could form the word words[i]
            solve(i + 1, score, words, currScore + tempScore, tempFreq);
        }

        // Not Take words[i]
        solve(i + 1, score, words, currScore, freq);
    }
}
