// https://leetcode.com/problems/sort-vowels-in-a-string/description/?envType=daily-question&envId=2023-11-13

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sort_Vowels_in_a_String {
    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(sortVowels(s));
        System.out.println(sortVowels_2(s));
    }

    // Approach-1 (Separate string create and sort)
    // T.C : O(nlog)
    public static String sortVowels(String s) {
        StringBuilder temp = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                temp.append(ch);
            }
        }

        char[] tempArray = temp.toString().toCharArray();
        Arrays.sort(tempArray);

        int j = 0;
        char[] resultArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                resultArray[i] = tempArray[j];
                j++;
            }
        }

        return new String(resultArray);
    }

    // Approach-2 (Without sorting. Counting the vowels - counting sort)
    // T.C : O(n)
    public static String sortVowels_2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        String vowels = "AEIOUaeiou";
        int j = 0; // pointing to temp (current vowel)

        char[] resultArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                while (map.getOrDefault(vowels.charAt(j), 0) == 0) {
                    j++;
                }

                resultArray[i] = vowels.charAt(j);
                map.put(vowels.charAt(j), map.get(vowels.charAt(j)) - 1);
            }
        }

        return new String(resultArray);
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
