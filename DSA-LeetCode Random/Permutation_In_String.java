//https://leetcode.com/problems/permutation-in-string/description/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation_In_String {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion_2(s1, s2));
    }

    // this approach shows TLE.
    public static boolean checkInclusion(String s1, String s2) {
        List<String> list = new ArrayList<>();
        list = permutation(s1, "", new ArrayList<String>());

        for (String str : list) {
            if (s2.contains(str)) {
                return true;
            }
        }

        return false;
    }

    // method to generate all the permutations of a given String str.
    public static List<String> permutation(String str, String ans, List<String> list) {
        if (str.isEmpty()) {
            list.add(ans);
            return list;
        }

        char ch = str.charAt(0);

        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i, ans.length());
            permutation(str.substring(1), (first + ch + second), list);
        }

        return list;
    }

    // this method runs fine.
    public static boolean checkInclusion_2(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        int s1Len = s1.length();
        int s2Len = s2.length();

        for (int i = 0; i <= s2Len - s1Len; i++) {
            Arrays.fill(arr1, 0);
            Arrays.fill(arr2, 0);
            if (isAnagram(s1, s2.substring(i, i + s1Len), arr1, arr2)) {
                return true;
            }
        }

        return false;

    }

    // method to check whether the String s1 and s2 are anagrams or not.
    public static boolean isAnagram(String s1, String s2, int[] arr1, int[] arr2) {

        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            arr2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;

    }
}
