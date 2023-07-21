//https://leetcode.com/problems/lexicographically-smallest-palindrome/

public class Lexicographically_Smallest_Palindrome {
    public static void main(String[] args) {
        String s = "seven";
        System.out.println(makeSmallestPalindrome(s));
    }

    public static String makeSmallestPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        StringBuilder str = new StringBuilder(s);

        while (start <= end) {

            // if the character at start and end are not same then just
            // replace the character with higher ascii value between the two
            // with the character having lower ascii value
            if (str.charAt(start) != str.charAt(end)) {
                if (str.charAt(start) > str.charAt(end)) {
                    str.setCharAt(start, str.charAt(end));
                }

                else {
                    str.setCharAt(end, str.charAt(start));
                }
            }

            start++;
            end--;
        }

        return str.toString();
    }
}
