//https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&id=leetcode-75

import java.util.ArrayList;

public class Reverse_Vowels_of_a_String {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        ArrayList<Character> vowels = new ArrayList<>();

        // just add the vowels as they appear in the string.
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                    || ch == 'O' || ch == 'U') {
                vowels.add(ch);
            }
        }

        StringBuilder ans = new StringBuilder(s);

        int index = vowels.size() - 1;
        for (int i = 0; i < ans.length(); i++) {
            char ch = ans.charAt(i);

            // when you find a character that is a vowel just replace it with the respective
            // vowel from the last from the vowel list.
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                    || ch == 'O' || ch == 'U') {
                ans.setCharAt(i, vowels.get(index));
                index--;
            }
        }

        return ans.toString();
    }
}
