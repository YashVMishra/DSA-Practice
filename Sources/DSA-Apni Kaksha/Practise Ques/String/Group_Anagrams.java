//https://leetcode.com/problems/group-anagrams/description/

import java.util.List;
import java.util.ArrayList;

public class Group_Anagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        else {
            int[] char_count = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char_count[s.charAt(i) - 'a']++;
                char_count[t.charAt(i) - 'a']--;
            }

            for (int i : char_count) {
                if (i != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static List<List<String>> groupAnagrams(String[] arr) {

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != "") {

                List<String> temp = new ArrayList<>();

                for (int j = i + 1; j < arr.length; j++) {

                    if (arr[j] != "") {

                        if (isAnagram(arr[i], arr[j])) {

                            temp.add(arr[j]);
                            arr[j] = "";
                        }

                    }

                }

                temp.add(arr[i]);
                ans.add(temp);
            }
        }

        return ans;
    }
}
