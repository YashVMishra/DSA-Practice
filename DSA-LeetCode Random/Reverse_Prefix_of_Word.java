// https://leetcode.com/problems/reverse-prefix-of-word/description/?envType=daily-question&envId=2024-05-01

public class Reverse_Prefix_of_Word {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));

        return sb.reverse().toString() + word.substring(index + 1);
    }
}
