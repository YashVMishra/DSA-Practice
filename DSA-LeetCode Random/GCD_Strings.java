//https://leetcode.com/problems/greatest-common-divisor-of-strings/description/

public class GCD_Strings {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {

        // very important condition for string that do not have GCD.
        // Example :- str1 = "LEET", str2 = "CODE".
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcd_strings(str1.length(), str2.length());

        return str2.substring(0, gcd);
    }

    public static int gcd_strings(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return gcd_strings(n2, n1 % n2);

    }
}
