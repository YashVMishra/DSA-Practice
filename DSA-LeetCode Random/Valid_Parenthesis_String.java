// https://leetcode.com/problems/valid-parenthesis-string/description/?envType=daily-question&envId=2024-04-07

import java.util.Arrays;
import java.util.Stack;

public class Valid_Parenthesis_String {
    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString_2("(*))"));
        System.out.println(checkValidString_3("(*))"));
    }

    public static boolean checkValidString(String s) {
        int n = s.length();
        int[][] t = new int[n][n];

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return isValidString(0, 0, s, t);
    }

    private static boolean isValidString(int idx, int open, String str, int[][] t) {
        if (idx == str.length()) {
            return (open == 0);
        }

        if (t[idx][open] != -1) {
            return t[idx][open] == 1;
        }

        boolean isValid = false;
        if (str.charAt(idx) == '*') {
            isValid |= isValidString(idx + 1, open + 1, str, t);

            if (open > 0) {
                isValid |= isValidString(idx + 1, open - 1, str, t);
            }

            isValid |= isValidString(idx + 1, open, str, t);
        } else {
            if (str.charAt(idx) == '(') {
                isValid = isValidString(idx + 1, open + 1, str, t);
            } else if (open > 0) {
                isValid = isValidString(idx + 1, open - 1, str, t);
            }
        }

        t[idx][open] = isValid ? 1 : 0;
        return isValid;
    }

    // --------------------------------------------------------------------------------

    public static boolean checkValidString_2(String s) {
        Stack<Integer> openSt = new Stack<>();
        Stack<Integer> asterisksSt = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openSt.push(i);
            } else if (ch == '*') {
                asterisksSt.push(i);
            } else {
                if (!openSt.isEmpty()) {
                    openSt.pop();
                } else if (!asterisksSt.isEmpty()) {
                    asterisksSt.pop();
                } else {
                    return false;
                }
            }
        }

        // This post processing will be required for cases like - "*(())(*"
        while (!openSt.isEmpty() && !asterisksSt.isEmpty()) {
            if (openSt.peek() > asterisksSt.peek()) {
                return false;
            }

            openSt.pop();
            asterisksSt.pop();
        }

        return openSt.isEmpty();
    }

    // --------------------------------------------------------------------------------

    public static boolean checkValidString_3(String s) {
        int open = 0;
        int close = 0;
        int n = s.length();

        // Left to Right - Check Open Brackets
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                open++;
            } else {
                open--;
            }

            if (open < 0) {
                return false;
            }
        }

        // Right to Left - Check Close Brackets
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                close++;
            } else {
                close--;
            }

            if (close < 0) {
                return false;
            }
        }

        return true;
    }
}
