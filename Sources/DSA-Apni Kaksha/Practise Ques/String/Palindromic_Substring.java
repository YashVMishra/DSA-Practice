//https://leetcode.com/problems/longest-palindromic-substring/description/

public class Palindromic_Substring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome_2("babad"));
        System.out.println(longestPalindrome_2("cbbd"));
    }

    // brute force solution.
    public static String longestPalindrome(String s) {

        String ans = "";
        int max_length = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);

                if (isPalin(temp) && temp.length() > max_length) {
                    ans = temp;
                    max_length = temp.length();
                }
            }
        }

        return ans;

    }

    public static boolean isPalin(String s) {

        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }

            else {
                return false;
            }
        }

        return true;
    }

    // optimal solution.
    public static String longestPalindrome_2(String s) {

        // start and end are for the substring method i.e str.substring(start, end)
        // is our answer.
        int start = 0;
        int end = 0;
        int size = s.length();
        int max_length = 0;

        // for palindromes like racecar i.e odd length
        for (int i = 0; i < size; i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < size) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                else {
                    break;
                }
            }

            // r-l-1=length of the current palindrome;
            if (r - l - 1 > max_length) {
                start = l + 1;
                end = r;
                max_length = r - l - 1;
            }
        }

        // for palindrome like abba i.e. of even length
        for (int i = 0; i < size; i++) {
            int l = i;
            int r = i + 1;

            while (l >= 0 && r < size) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                else {
                    break;
                }
            }

            // r-l-1=length of the current palindrome;
            if (r - l - 1 > max_length) {
                start = l + 1;
                end = r;
                max_length = r - l - 1;
            }
        }

        return s.substring(start, end);
    }
}
