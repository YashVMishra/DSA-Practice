// https://leetcode.com/problems/find-words-containing-character/description/

import java.util.ArrayList;
import java.util.List;

public class Find_Words_Containing_Character {
    public static void main(String[] args) {
        String[] words = { "hello", "world", "java", "programming", "language" };
        char x = 'a';

        System.out.println(findWordsContaining(words, x));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> index = new ArrayList<Integer>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                index.add(i);
            }
        }

        return index;
    }
}
