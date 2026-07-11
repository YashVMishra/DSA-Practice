import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group_Anagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 1) {
            return Arrays.asList(Arrays.asList(strs));
        }

        List<List<String>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(strs[0])));

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < ans.size(); j++) {
                if (isAnagram(strs[i], ans.get(j).get(0))) {
                    ans.get(j).add(strs[i]);
                    break;
                } else if (j == ans.size() - 1) {
                    ans.add(new ArrayList<>(Arrays.asList(strs[i])));
                    break; // important condition, else the last element might be added multiple times.
                }
            }
        }

        return ans;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
