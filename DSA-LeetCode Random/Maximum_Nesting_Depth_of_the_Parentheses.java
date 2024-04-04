// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/?envType=daily-question&envId=2024-04-04

import java.util.Stack;

public class Maximum_Nesting_Depth_of_the_Parentheses {
    public static void main(String[] args) {
        String s = "(1)+((2))+(((3)))";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxdepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                maxdepth = Math.max(maxdepth, stack.size());
            } else if (c == ')') {
                stack.pop();
            }
        }

        return maxdepth;
    }

    // ---------------------------------------------------------------------------------

    public static int maxDepth_2(String s) {
        int leftBracketCount = 0;
        int maxdepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftBracketCount++;
                maxdepth = Math.max(maxdepth, leftBracketCount);
            } else if (c == ')') {
                leftBracketCount--;
            }
        }

        return maxdepth;
    }
}
