//https://leetcode.com/problems/palindrome-number/

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(234432));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int ans = 0;

        while (temp > 0) {
            ans = (ans * 10) + temp % 10;
            temp /= 10;
        }

        if (ans == x) {
            return true;
        }

        return false;
    }
}
