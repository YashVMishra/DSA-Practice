// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2023-11-14

import java.util.Arrays;
import java.util.HashSet;

public class Unique_Length_3_Palindromic_Subsequences {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
    }

    // brute force
    // shows TLE.
    public static int countPalindromicSubsequence(String s) {
        HashSet<String> subseq = new HashSet<>();
        generateSubseq(s, 0, "", subseq);
        int count = 0;

        for (String str : subseq) {
            if (isPalindrome(str)) {
                count++;
            }
        }

        return count;
    }

    // generate all the subsequences of s of length 3
    public static void generateSubseq(String s, int index, String curr, HashSet<String> subseq) {
        if (index == s.length()) {
            if (curr.length() == 3) {
                subseq.add(curr);
            }

            return;
        }

        // take
        generateSubseq(s, index + 1, curr + s.charAt(index), subseq);

        // not take
        generateSubseq(s, index + 1, curr, subseq);
    }

    // return true if s is palindrome
    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (j > i) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

    // --------------------------------------------------------------------------------

    public static int countPalindromicSubsequence_2(String s) {
        HashSet<Character> totalUnique = new HashSet<>();
        HashSet<Character> currUnique = new HashSet<>();
        int count = 0;

        for (char ch : s.toCharArray()) {
            totalUnique.add(ch);
        }

        for (char ch : totalUnique) {
            int leftIndex = s.indexOf(ch);
            int rightIndex = s.lastIndexOf(ch);

            for (int i = leftIndex + 1; i <= rightIndex - 1; i++) {
                currUnique.add(s.charAt(i));
            }

            count += currUnique.size();
            currUnique.clear();
        }

        return count;
    }

    // --------------------------------------------------------------------------------

    // same approach as above but in this we have
    // pre-computed the left and right index.
    public static int countPalindromicSubsequence_3(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        int count = 0;

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (first[index] == -1) {
                first[index] = i;
            }

            last[index] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            HashSet<Character> currUnique = new HashSet<>();
            for (int j = first[i] + 1; j <= last[i] - 1; j++) {
                currUnique.add(s.charAt(j));
            }

            count += currUnique.size();
        }

        return count;
    }
}
