//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

import java.util.Stack;

public class Reverse_Polish_Notation {
    public static void main(String[] args) {
        String[] arr = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(evalRPN(arr));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int top_1 = stack.peek();
                stack.pop();
                int top_2 = stack.peek();
                stack.pop();
                stack.push(top_1 + top_2);
            }

            else if (tokens[i].equals("-")) {
                int top_1 = stack.peek();
                stack.pop();
                int top_2 = stack.peek();
                stack.pop();
                stack.push(top_2 - top_1);
            }

            else if (tokens[i].equals("*")) {
                int top_1 = stack.peek();
                stack.pop();
                int top_2 = stack.peek();
                stack.pop();
                stack.push(top_1 * top_2);
            }

            else if (tokens[i].equals("/")) {
                int top_1 = stack.peek();
                stack.pop();
                int top_2 = stack.peek();
                stack.pop();
                stack.push(top_2 / top_1);
            }

            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.peek();
    }
}
