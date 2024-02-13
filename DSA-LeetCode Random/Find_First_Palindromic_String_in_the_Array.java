// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/?envType=daily-question&envId=2024-02-13

public class Find_First_Palindromic_String_in_the_Array {
    public static void main(String[] args) {
        String[] words = { "hello", "world", "racecar", "goodbye" };
        System.out.println(firstPalindrome(words));
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return "";
    }

    public static boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;

        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
