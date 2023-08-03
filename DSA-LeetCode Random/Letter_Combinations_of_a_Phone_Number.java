// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        char[][] arr = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
                { 'm', 'n', 'o' },
                { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

        ArrayList<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        return helper(digits, "", arr, ans);
    }

    public static List<String> helper(String digits, String word, char[][] arr, ArrayList<String> ans) {
        if (digits.length() == 0) {
            ans.add(word);
            return ans;
        }

        int digit = digits.charAt(0) - '0';

        if (digit == 1) {
            helper(digits.substring(1), word, arr, ans);
        } else {
            for (int i = 0; i < arr[digit].length; i++) {
                helper(digits.substring(1), word + arr[digit][i], arr, ans);
            }
        }

        return ans;
    }
}
