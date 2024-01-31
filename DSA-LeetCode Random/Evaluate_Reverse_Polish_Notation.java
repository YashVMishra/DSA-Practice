// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=daily-question&envId=2024-01-30

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = st.pop();
                int a = st.pop();

                result = operate(a, b, s);
                st.push(result);
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }

    public static int operate(int a, int b, String s) {
        if (s.equals("+"))
            return a + b;

        if (s.equals("-"))
            return a - b;

        if (s.equals("*"))
            return (int) ((long) a * (long) b);

        if (s.equals("/"))
            return a / b;

        return -1;
    }
}
