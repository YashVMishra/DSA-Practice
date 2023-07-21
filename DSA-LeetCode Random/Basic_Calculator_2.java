//https://leetcode.com/problems/basic-calculator-ii/description/

import java.util.Stack;

public class Basic_Calculator_2 {
    public static void main(String[] args) {
        String str = "3/2";
        System.out.println(calculate(str));
        System.out.println(calculate_2(str));
    }

    // method that uses stack for computation.
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = s.length();

        // stack will contain only the parts which are to be added.
        int curr_number = 0;
        char operation = '+';

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                curr_number = (curr_number * 10) + (ch - '0');
            }

            if ((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-curr_number);
                }

                if (operation == '+') {
                    stack.push(curr_number);
                }

                if (operation == '*') {
                    int temp = stack.peek();
                    stack.pop();
                    stack.push(curr_number * temp);
                }

                if (operation == '/') {
                    int temp = stack.peek();
                    stack.pop();
                    stack.push(temp / curr_number);
                }

                curr_number = 0;
                operation = ch;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.peek();
            stack.pop();
        }

        return result;
    }

    // using O(1) space.
    public static int calculate_2(String s) {
        int len = s.length();

        int curr_number = 0;
        int sign = '+';
        int last_number = 0;
        int result = 0;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                curr_number = (curr_number * 10) + (ch - '0');
            }

            if ((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == len - 1) {
                if (sign == '+' || sign == '-') {
                    result += last_number;
                    last_number = (sign == '+') ? curr_number : -curr_number;
                }

                else if (sign == '*') {
                    last_number *= curr_number;
                }

                else if (sign == '/') {
                    last_number /= curr_number;
                }

                sign = ch;
                curr_number = 0;
            }
        }

        // important to add the last last_number.
        result += last_number;
        return result;
    }
}
