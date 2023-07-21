//https://leetcode.com/problems/valid-palindrome/

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        String palin = "";

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                palin += c;
            }
        }

        int start = 0;
        int end = palin.length() - 1;

        while (start <= end) {
            if (palin.charAt(start) != palin.charAt(end)) {
                return false;
            }

            else {
                start++;
                end--;
            }
        }

        return true;
    }
}
