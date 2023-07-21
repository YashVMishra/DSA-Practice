//https://leetcode.com/problems/validate-stack-sequences/description/

import java.util.Stack;

public class Validate_Stack_Sequences {
    public static void main(String[] args) {
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 4, 5, 3, 2, 1 };
        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;

        for (int p : pushed) {
            st.push(p);

            while (!st.isEmpty() && j < popped.length && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }

        return j == popped.length;
    }
}
