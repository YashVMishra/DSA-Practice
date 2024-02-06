// https://leetcode.com/problems/group-anagrams/description/?envType=daily-question&envId=2024-02-06

import java.util.ArrayList;
import java.util.List;

public class Group_Anagrams {
    public static void main(String[] args) {
        String[] strs = { "" };
        System.out.println(groupAnagrams(strs));
    }

    // in this function we take one string from the array and compare it with all
    // if we find the anagram of it then we just make it null and add it to the list
    // and at the end we add the list to the main list
    // and then we make the string which we are comparing to null as well.

    // keep in mind the check for null pointer.
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                continue;
            }

            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j] != null && isAnagram(strs[j], strs[i])) {
                    temp.add(strs[j]);
                    strs[j] = null;
                }
            }

            ans.add(temp);
            strs[i] = null;
        }

        return ans;
    }

    // -----------------------------------------------------------------------

    // in this we take one string from the array and initialize a boolean variable
    // to false, then we iterate over the individual lists and check if the string
    // is anagram to any of the list, if yes then we make the boolean variable true
    // and break from the loop, if not then we add the string to a new list and add
    // that list to the main list.
    public static List<List<String>> groupAnagrams_2(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            boolean found = false;

            for (int j = 0; j < ans.size(); j++) {
                if (isAnagram(strs[i], ans.get(j).get(0))) {
                    ans.get(j).add(strs[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                ans.add(temp);
            }
        }

        return ans;
    }

    // -----------------------------------------------------------------------

    // utility function
    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] temp = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            temp[s1.charAt(i) - 'a']++;
            temp[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
