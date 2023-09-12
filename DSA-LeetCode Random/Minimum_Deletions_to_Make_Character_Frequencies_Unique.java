// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/

import java.util.Arrays;
import java.util.HashSet;

public class Minimum_Deletions_to_Make_Character_Frequencies_Unique {
    public static void main(String[] args) {
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));

        System.out.println(minDeletions_2("aaabbbcc"));
        System.out.println(minDeletions_2("ceabaacb"));
    }

    // in this we can even delete the whole character.
    // here we have first counted the freq of each charcter
    // then we have used a set to keep track of the freq of each character
    // if the freq is already present in the set then we have to subtract
    // the freq of that character by one and increment the deletions by one
    // keep on doing this while the condition in the while loop is true
    public static int minDeletions(String s) {
        int deletions = 0;
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0 && set.contains(freq[i])) {
                freq[i]--;
                deletions++;
            }

            set.add(freq[i]);
        }

        return deletions;
    }

    // in this we have first counted the freq of each charcter
    // then sorted that array in ascending order
    // and start traversion from the second last element and compare it with
    // the next element and if the condition freq[i] >= freq[i + 1] is true
    // then we have to maintain the ascending order so we have make the
    // freq[i] = freq[i + 1] - 1 and increment the deletions by the difference
    // between the previous and the current freq.
    public static int minDeletions_2(String s) {
        int deletions = 0;
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            }

            if (freq[i] >= freq[i + 1]) {
                int prev = freq[i];
                freq[i] = Math.max(0, freq[i + 1] - 1);
                deletions += prev - freq[i];
            }
        }

        return deletions;
    }
}
