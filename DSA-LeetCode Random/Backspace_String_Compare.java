//https://leetcode.com/problems/backspace-string-compare/description/?envType=study-plan&id=level-1

import java.util.Stack;

public class Backspace_String_Compare {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        String str1 = build(s);
        String str2 = build(t);

        return str1.equals(str2);
    }

    public static String build(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack.add(s.charAt(i));
            }

            else {

                // pop only when the stack is not empty else it will throw error.
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return String.valueOf(stack);
    }
}
