// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=leetcode-75

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

        helper(digits, new StringBuilder(), arr, ans, 0);
        return ans;
    }

    public static void helper(String digits, StringBuilder word, char[][] arr, ArrayList<String> ans, int index) {
        if (index >= digits.length()) {
            ans.add(word.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        char[] letters = arr[digit];

        for (int i = 0; i < letters.length; i++) {
            word.append(letters[i]);
            helper(digits, word, arr, ans, index + 1);
            word.deleteCharAt(word.length() - 1);
        }
    }
}
