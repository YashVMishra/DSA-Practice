//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagrams_in_String {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams_2(s, p));
        System.out.println(findAnagrams_1(s, p));
    }

    // using sliding window protocol.
    // shows better TC than the lower one.
    public static List<Integer> findAnagrams_1(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int slen = s.length();
        int plen = p.length();

        if (slen < plen) {
            return list;
        }

        int[] shash = new int[26];
        int[] phash = new int[26];

        for (int i = 0; i < p.length(); i++) {
            shash[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            phash[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = plen - 1;

        while (right < s.length()) {
            if (Arrays.equals(shash, phash)) {
                list.add(left);
            }

            right++;

            if (right != s.length()) {
                shash[s.charAt(right) - 'a']++;
                shash[s.charAt(left) - 'a']--;
            }

            left++;
        }

        return list;
    }

    // just send substring of length p from s and check for anagram.
    public static List<Integer> findAnagrams_2(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int slen = s.length();
        int plen = p.length();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i <= slen - plen; i++) {
            Arrays.fill(arr1, 0);
            Arrays.fill(arr2, 0);
            if (isAnagram(s.substring(i, i + plen), p, arr1, arr2)) {
                list.add(i);
            }
        }

        return list;
    }

    // method to check anagrams.
    public static boolean isAnagram(String s, String p, int[] arr1, int[] arr2) {

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            arr2[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
