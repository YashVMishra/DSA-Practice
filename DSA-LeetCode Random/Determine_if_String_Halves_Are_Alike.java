// https://leetcode.com/problems/determine-if-string-halves-are-alike/description/?envType=daily-question&envId=2024-01-12

import java.util.HashSet;

public class Determine_if_String_Halves_Are_Alike {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlike("MerryChristmas"));
        System.out.println(halvesAreAlike("AbCdEfGh"));
    }

    public static boolean halvesAreAlike(String s) {
        int len = s.length();
        int halfLen = len / 2;
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int count = 0;
        for (int i = 0; i < halfLen; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }

        for (int i = halfLen; i < len; i++) {
            if (vowels.contains(s.charAt(i))) {
                count--;
            }
        }

        return count == 0;
    }
}
