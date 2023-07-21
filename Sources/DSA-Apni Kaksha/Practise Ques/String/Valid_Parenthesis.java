//https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class Valid_Parenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        char ch = s.charAt(0);
        if (ch == '}' || ch == ')' || ch == ']') {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        int count = 0; // for the closing brackets that do not have opening brackets.

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }

            else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }

            else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }

            else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }

            else {
                count++;
            }
        }

        if (count > 0) {
            return false;
        }

        return stack.isEmpty();
    }
}
