//https://leetcode.com/problems/longest-palindrome/description/?envType=study-plan&id=level-1

public class Longest_Palindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[123];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int ans = 0;
        boolean isOdd = false;

        for (int i : count) {
            if (i % 2 != 0) {
                isOdd = true;
                ans += i - 1;
            }

            if (i % 2 == 0) {
                ans += i;
            }
        }

        if (isOdd) {
            ans++;
        }

        return ans;
    }
}