//https://leetcode.com/problems/substring-with-largest-variance/description/

public class Substring_With_Largest_Variance {
    public static void main(String[] args) {
        String s = "aababbb";
        System.out.println(largestVariance(s));
    }

    public static int largestVariance(String s) {
        int[] currFreq = new int[26];
        int[][] freq = new int[s.length()][26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            currFreq[ch - 'a']++;
            freq[i] = currFreq.clone();
        }

        int ans = 0;
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                if (a == b || freq[s.length() - 1][a] == 0 || freq[s.length() - 1][b] == 0) {
                    continue;
                }

                int bFreq = 0, aFreq = 0;
                for (int k = 0; k < s.length(); k++) {
                    int currChar = s.charAt(k) - 'a';

                    if (currChar == a) {
                        aFreq++;
                    }

                    if (currChar == b) {
                        bFreq++;
                    }

                    if (aFreq > 0) {
                        ans = Math.max(ans, bFreq - aFreq);
                    }

                    // if a occurs more than b till now, then skip that substring and start
                    // counting from now.
                    if (bFreq < aFreq && freq[s.length() - 1][a] - freq[k][a] != 0) {
                        bFreq = 0;
                        aFreq = 0;
                    }
                }
            }
        }

        return ans;
    }
}
