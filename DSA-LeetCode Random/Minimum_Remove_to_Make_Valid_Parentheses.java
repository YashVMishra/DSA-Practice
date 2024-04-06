// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/?envType=daily-question&envId=2024-04-06i

import java.util.HashSet;
import java.util.Stack;

class Pair {
    int index;
    char ch;

    public Pair(int index, char ch) {
        this.index = index;
        this.ch = ch;
    }
}

public class Minimum_Remove_to_Make_Valid_Parentheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));

        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(new Pair(i, ch));
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek().ch == '(') {
                    stack.pop();
                } else {
                    stack.push(new Pair(i, ch));
                }
            }
        }

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            s = s.substring(0, pair.index) + s.substring(pair.index + 1);
        }

        return s;
    }

    // --------------------------------------------------------------------------------

    public static String minRemoveToMakeValid_2(String s) {
        int n = s.length();

        HashSet<Integer> toRemove = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push(i);
            else if (ch == ')') {
                if (st.isEmpty())
                    toRemove.add(i);
                else
                    st.pop();
            }
        }

        while (!st.isEmpty())
            toRemove.add(st.pop());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!toRemove.contains(i))
                result.append(s.charAt(i));
        }

        return result.toString();
    }
}
