// https://leetcode.com/problems/backspace-string-compare/description/?envType=daily-question&envId=2023-10-19

import java.util.Stack;

public class Backspace_String_Compare {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        String str1 = build_2(s);
        String str2 = build_2(t);

        return str1.equals(str2);
    }

    // using stack.
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

    // using functions of StringBuilder class.
    public static String build_2(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        return sb.toString();
    }

    // using a pointer and an array.
    public static String build_3(String s) {
        int index = 0;
        int[] arr = new int[s.length()];

        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                arr[index++] = ch;
            }

            else {
                if (index > 0) {
                    index--;
                }
            }
        }

        return new String(arr, 0, index);
    }
}
