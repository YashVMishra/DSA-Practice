// https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Stack;

public class Removing_Stars_From_String {
    public static void main(String[] args) {
        String str = "leet**cod*e";
        System.out.println(removeStars(str));
        System.out.println(removeStars_2(str));
        System.out.println(removeStars_3(str));
    }

    // uses stack.
    public static String removeStars(String s) {
        String ans = "";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
            }

            else {
                stack.add(s.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            char ch = stack.peek();
            stack.pop();
            ans = ch + ans;
        }

        return ans;
    }

    // much faster than the method that uses stack.
    // uses methods of string builder.
    public static String removeStars_2(String s) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                answer.deleteCharAt(answer.length() - 1);
            }

            else {
                answer.append(s.charAt(i));
            }
        }

        return answer.toString();
    }

    // fastest of them all.
    // uses an array and a pointer.
    public static String removeStars_3(String str) {
        int j = 0;
        char[] temp = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '*') {
                j--;
            }

            else {
                temp[j++] = ch;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < j; i++) {
            ans.append(temp[i]);
        }

        return ans.toString();
    }
}
