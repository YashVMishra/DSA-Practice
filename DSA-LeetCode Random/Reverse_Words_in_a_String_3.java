// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/?envType=daily-question&envId=2023-10-01

public class Reverse_Words_in_a_String_3 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        String ans = "";

        for (String word : words) {
            ans += reverse(word) + " ";
        }

        return ans.trim();
    }

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }

        return new String(chars);
    }
}
