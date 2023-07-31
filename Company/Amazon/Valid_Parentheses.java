// https://leetcode.com/problems/valid-parentheses/description/

// do on your own or else see any youtube video

import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        char ch = s.charAt(0);
        if (ch == '}' || ch == ']' || ch == ')') {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        // for inputs like {}[]}}.
        // that is string that ends with closing brackets after a
        // valid set of parentheses.
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (temp == '[' || temp == '{' || temp == '(') {
                stack.push(temp);
            }

            else if (temp == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }

            else if (temp == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }

            else if (temp == ')' && !stack.isEmpty() && stack.peek() == '(') {
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