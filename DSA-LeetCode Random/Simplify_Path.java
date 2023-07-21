//https://leetcode.com/problems/simplify-path/description/

import java.util.Stack;

public class Simplify_Path {
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        String[] temp = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < temp.length; i++) {
            if (!stack.isEmpty() && temp[i].equals("..")) {
                stack.pop();
            }

            else if (!temp[i].equals("") && !temp[i].equals(".") && !temp[i].equals("..")) {
                stack.push(temp[i]);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop()).insert(0, "/");
        }

        return ans.toString();
    }
}
