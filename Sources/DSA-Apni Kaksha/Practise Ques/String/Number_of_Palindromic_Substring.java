//https://leetcode.com/problems/palindromic-substrings/

public class Number_of_Palindromic_Substring {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);

                if (isPalin(temp)) {
                    count++;
                }
            }
        }

        return count;
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
}
