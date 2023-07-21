//https://leetcode.com/problems/generate-parentheses/description/

import java.util.List;
import java.util.ArrayList;

public class Generate_Parentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        findAll("(", 1, 0, list, n);

        return list;

    }

    // try to observe the question and try to find out some rules by your own.
    public static void findAll(String current, int open, int close, List<String> list, int n) {
        if (current.length() == 2 * n) {
            list.add(current);
            return;
        }

        if (open < n) {
            findAll(current + "(", open + 1, close, list, n);
        }

        if (close < open) {
            findAll(current + ")", open, close + 1, list, n);
        }
    }
}
