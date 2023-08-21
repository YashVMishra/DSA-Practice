// https://leetcode.com/problems/repeated-substring-pattern/description/

public class Repeated_Substring_Pattern {
    public static void main(String[] args) {
        String str = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(str));
        System.out.println(repeatedSubstringPattern_2(str));
    }

    // brute force but does not show TLE.
    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String substr = s.substring(0, i);
            if (check(s, substr)) {
                return true;
            }
        }

        return false;
    }

    public static boolean check(String str, String substr) {
        String temp = "";
        for (int i = 0; i < str.length() / substr.length(); i++) {
            temp += substr;
        }

        return str.equals(temp);
    }

    // uses the same logic but better TC and it does not check the
    // substring of length which is not a factor of the length of the
    // main string.
    public static boolean repeatedSubstringPattern_2(String s) {
        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                StringBuilder pattern = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    pattern.append(s.substring(0, i));
                }

                if (s.equals(pattern.toString())) {
                    return true;
                }
            }
        }

        return false;
    }
}
