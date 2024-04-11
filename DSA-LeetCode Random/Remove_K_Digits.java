// https://leetcode.com/problems/remove-k-digits/description/?envType=daily-question&envId=2024-04-11

import java.util.Stack;

public class Remove_K_Digits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                k--;
                stack.pop();
            }

            stack.push(digit);
        }

        // edge case when the number is in sorted order.
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {

            // using this to prevent leading zeroes.
            if (sb.length() == 0 && ch == '0') {
                continue;
            } else {
                sb.append(ch);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
