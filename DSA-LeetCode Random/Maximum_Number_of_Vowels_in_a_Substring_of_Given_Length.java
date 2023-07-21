//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

import java.util.Set;

public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    public static void main(String[] args) {
        String s = "weallloveyou";
        int k = 7;
        System.out.println(maxVowels_1(s, k));
        System.out.println(maxVowels_2(s, k));
        System.out.println(maxVowels_3(s, k));
    }

    // simple just consider all the substrings of s of length k
    // and check the count of vowel in them.
    // show TLE.
    public static int maxVowels_1(String s, int k) {
        int ans = 0;

        for (int i = 0; i <= s.length() - k; i++) {
            String str = s.substring(i, i + k);
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }

            ans = Math.max(count, ans);
        }

        return ans;
    }

    // Build a hash set vowels that contains all 5 vowel letters, initialize answer
    // as 0.
    // Record the number of vowel letters in the first k letters as count.
    // Now we move the "window" to the right, let i be the index of its right
    // boundary:
    // If s[i] is in vowels, increment count by 1.
    // If s[i - k] is in vowels, reduce count by 1.
    // Update answer as the maximum count we have encountered.
    // Return answer after the iteration ends.
    public static int maxVowels_2(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }

        int ans = count;
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }

            if (set.contains(s.charAt(i - k))) {
                count--;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }

    // just the implementation of the above method without using the Set DS.
    public static int maxVowels_3(String s, int k) {
        int count = 0;
        int ans = 0;

        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        ans = count;
        int right = k;

        while (right < s.length()) {

            // right-k gives the index of the character we want to delete the count of.
            char ch1 = s.charAt(right - k);
            if (ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') {
                count--;
            }

            char ch2 = s.charAt(right);
            if (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u') {
                count++;
            }

            ans = Math.max(count, ans);
            right++;
        }

        return ans;
    }
}
