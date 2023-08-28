// https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Determine_if_Two_Strings_Are_Close {
    public static void main(String[] args) {

    }

    public static boolean closeStrings_1(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // counting the frequency of each character in both the strings.
        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // checking condition 1.
        // every character in word1 must be present in word2 irrespective of their
        // frequency.
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // checking condition 2.
        // the set of frequency of both word should be equal.
        // like if word1 has 2, 3, 4 as frequncy list and word2 has 2, 3, 4 then it is
        // valid, irrespective of their character.
        ArrayList<Integer> list1 = new ArrayList<>(map1.values());
        ArrayList<Integer> list2 = new ArrayList<>(map2.values());
        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }

    public static boolean closeStrings_2(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        // checking condition 1.
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == 0 && freq2[i] > 0 || freq2[i] == 0 && freq1[i] > 0) {
                return false;
            }
        }

        // checking condition 2.
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}
