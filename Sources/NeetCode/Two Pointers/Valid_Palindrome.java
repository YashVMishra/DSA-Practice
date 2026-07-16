public class Valid_Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    // keep 2 indexes, from left loop till you dont hit a letter
    // or digit, similar to right index, and then compare those 2 characters
    // always update the right and left indexes in the checking condition to avoid
    // redundant check. Only skip non - alphanumeric values
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }

        int leftCharIndex = 0;
        int rightCharIndex = s.length() - 1;

        while (leftCharIndex < rightCharIndex) {
            if (!Character.isLetterOrDigit(s.charAt(leftCharIndex))) {
                leftCharIndex++;
            } else if (!Character.isLetterOrDigit(s.charAt(rightCharIndex))) {
                rightCharIndex--;
            } else {
                if (Character.toLowerCase(s.charAt(rightCharIndex)) != Character.toLowerCase(s.charAt(leftCharIndex))) {
                    return false;
                }

                leftCharIndex++;
                rightCharIndex--;
            }
        }

        return true;
    }
}