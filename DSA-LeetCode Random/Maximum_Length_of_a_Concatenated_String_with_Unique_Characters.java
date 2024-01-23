// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/?envType=daily-question&envId=2024-01-23

import java.util.List;

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
    public static void main(String[] args) {
        List<String> arr = List.of("un", "iq", "ue");
        System.out.println(maxLength(arr));
    }

    // this ques can be done by recursion only
    // u don't need to use DP.
    public static int maxLength(List<String> arr) {
        return solve(arr, 0, "");
    }

    private static int solve(List<String> arr, int idx, String ans) {
        if (idx == arr.size()) {
            return ans.length();
        }

        int include = 0;
        if (isUnique(ans + arr.get(idx))) {
            include = solve(arr, idx + 1, ans + arr.get(idx));
        }

        int exclude = solve(arr, idx + 1, ans);

        return Math.max(include, exclude);
    }

    private static boolean isUnique(String str) {
        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i) - 'a'] > 0) {
                return false;
            }

            freq[str.charAt(i) - 'a']++;
        }

        return true;
    }
}
