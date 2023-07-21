//https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1

public class Longest_Prefix_Suffix {
    public static void main(String[] args) {
        String str = "aaaa";
        System.out.println(prefix_suffix(str));
    }

    public static int prefix_suffix(String str) {
        int n = str.length();

        if (str.length() == 1) {
            return 0;
        }

        long p = 31;
        long mod = 1000000007;
        long pow = 1;

        long ph = 0;
        long sh = 0;
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ph = ((ph * p) + (str.charAt(i) - 'a' + 1)) % mod;
            sh = (sh + ((str.charAt(n - i - 1) - 'a' + 1) * pow) % mod) % mod;

            pow = (pow * p) % mod;

            if (ph == sh) {
                ans = i + 1;
            }
        }

        return ans;

    }
}
