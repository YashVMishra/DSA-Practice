//https://leetcode.com/problems/decode-ways/description/

public class Decode_Ways {
    public static void main(String[] args) {
        System.out.println(numDecodings("1123"));
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        dp[0] = 1;
        dp[1] = 1;
        int len = s.length();

        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') {
                dp[i] = dp[i - 1];
            }

            if (s.charAt(i - 2) == '1') {
                dp[i] += dp[i - 2];
            }

            else if (s.charAt(i - 2) == '2' && (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[len];
    }
}