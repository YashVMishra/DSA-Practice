// https://leetcode.com/problems/make-the-string-great/description/?envType=daily-question&envId=2024-04-05

import java.util.Stack;

public class Make_The_String_Great {
    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // thee if-clause is used to check for capital letters
        // and remove them accordingly while the else-if clause is used
        // lowercase lettter and remove them accordingly
        for (char ch : s.toCharArray()) {
            if (ch >= 65 && ch <= 90 && !stack.isEmpty() && stack.peek() == (char) (ch + 32)) {
                stack.pop();
            } else if (ch >= 97 && ch <= 122 && !stack.isEmpty() && stack.peek() == (char) (ch - 32)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }

    // --------------------------------------------------------------------------------

    public static String makeGood_2(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // thee if-clause is used to check for capital letters
        // and remove them accordingly while the else-if clause is used
        // lowercase lettter and remove them accordingly

        // if we look deeply into this then we can see that when we have to pop
        // we just have to make sure that the top of the stack is either 32 more
        // than the current charcater or 32 less than the current character.
        // so for that we can do with only if-else clause.
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(ch - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}