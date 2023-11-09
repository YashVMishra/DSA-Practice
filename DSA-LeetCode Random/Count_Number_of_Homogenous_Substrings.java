// https://leetcode.com/problems/count-number-of-homogenous-substrings/description/?envType=daily-question&envId=2023-11-09

public class Count_Number_of_Homogenous_Substrings {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        String s = "zzzzz";
        System.out.println(countHomogenous_2(s));
    }

    // shows TLE.
    // in this we are just comparing the characters and not the substrings.
    // if the characters at i and j are same then we increment the count.
    // we have to start the j counter from i because we have to count the
    // single length substrings as well.
    public static int countHomogenous(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                    count %= MOD;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    // --------------------------------------------------------------------------------

    // using the fact that a string of length n will have n*(n+1)/2 substrings.
    // we will keep track of the length of the substring and add it to the result.
    public static int countHomogenous_2(String s) {
        int length = 1;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                length++;
            } else {
                length = 1;
            }

            result += length;
            result %= MOD;

        }

        return result;
    }
}
